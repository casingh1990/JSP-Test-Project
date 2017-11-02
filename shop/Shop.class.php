<?php

class Shop
{

  public $queue;
  public $apples;
  public $quantity;

  public function __construct()
  {
    $this->queue  = new SplMinHeap();
    $this->apples = array();
  }

  public function check_apples($now)
  {
    while ($this->queue->top() <= $now)
    {
      $this->delete_current_apple();
    }
  }
  
  private function debug($msg){
    return;
    echo "<div style=\"border:1px solid black;\"><pre>";
    var_dump($msg);
    echo "</pre></div>";
  }

  public function buy($now, $quantity, $expiry)
  {
    $this->queue->insert(intval($expiry));
    $this->apples[intval($expiry)] = intval($quantity);
    $this->quantity                += intval($quantity);
    $this->check_apples($now);
    return $this->quantity;
  }

  private function get_current_apple_quantity()
  {
    $cur = intval($this->queue->top());
    return intval($this->apples[$cur]);
  }

  private function delete_current_apple()
  {
    $cur            = intval($this->queue->top());
    $this->queue->extract();
    $this->quantity -= $this->apples[$cur];
    unset($this->apples[$cur]);
  }

  private function remove_apples($req_quantity)
  {
    $quantity = intval($req_quantity);
    $this->debug("Removing $quantity from " . $this->get_current_apple_quantity() . "<br />");
    $this->debug($this->quantity);
    if ($this->get_current_apple_quantity() > $quantity)
    {
      $cur                = $this->queue->top();
      $this->apples[$cur] -= $quantity;
      $this->quantity     -= $quantity;
    }
    $this->debug($this->quantity);
  }

  private function sell_helper($req_quantity)
  {
    $quantity     = intval($req_quantity);
    $cur_quantity = 0;
    do
    {
      $this->debug("Starting with " . $this->quantity);
      $cur_apple_count = $this->get_current_apple_quantity();
      $cur_quantity    += $cur_apple_count;
      $quantity_this_round = ($quantity >= $cur_quantity)?$cur_quantity:($cur_quantity - $quantity);

      if ($quantity_this_round >= $cur_apple_count)
      {
        $this->debug("deleting $quantity_this_round >= $cur_apple_count");
        $this->delete_current_apple();
      }
      else
      {
        if ($quantity_this_round < $cur_apple_count)
        {
          $this->remove_apples($cur_apple_count - $quantity_this_round);
        }
        else{
          $this->debug("unreachable code");
        }
        $cur_quantity = $quantity;
      }
      $this->debug($this->quantity);
      $this->debug("while ($cur_quantity < $quantity);<br />");
    }
    while ($cur_quantity < $quantity);
  }

  public function sell($now, $quantity)
  {
    $this->check_apples($now);
    $this->sell_helper($quantity);
    return $this->quantity;
  }

}
