package multiThreading;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

public class CompletableFutureExample {

    public static  void main(String args[]) {
        List<CompletableFuture<Order>> list = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            int count = i;
            CompletableFuture completableFuture = CompletableFuture.supplyAsync(() -> Order.getOrder("Order"+ count))
                    .thenApply(order -> Order.enrichOrder(order))
                    .thenApply(order -> Order.getPayment(order))
                    .thenApply(order -> Order.dispatchOrder(order))
                    .thenAccept(order -> Order.sendMail(order));
             list.add(completableFuture);
        }

        for(CompletableFuture<Order> cf : list) {
            try {
                 if(cf.get()==null) {
                    cf.wait();
                 }
                 else
                 {
                     Order o = cf.get();
                     System.out.println(o.getOrderName() +"and their status is"+o.getStatus());
                     cf.notifyAll();
                 }

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        }
    }
}



class Order
{
    private String OrderName ;
    private String Status;
    private Boolean isPayment = false;
    private String sendMail;

    public String getOrderName() {
        return OrderName;
    }

    public void setOrderName(String orderName) {
        OrderName = orderName;
    }

    public String getStatus() {
        return Status;
    }

    public void setStatus(String status) {
        Status = status;
    }

    public Boolean getPayment() {
        return isPayment;
    }

    public void setPayment(Boolean payment) {
        isPayment = payment;
    }

    public String getSendMail() {
        return sendMail;
    }

    public void setSendMail(String sendMail) {
        this.sendMail = sendMail;
    }

    static Order getOrder(String OderName)
    {
        System.out.println(OderName +" has been received");
         Order o = new Order();
         o.setOrderName(OderName);
         o.setStatus("received");
        return o;
    }

    static Order enrichOrder(Order o)  {
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        o.setStatus("orderEnriched");
        System.out.println(o.getOrderName()+ "has orderEnriched");
       return o;
    }

    static Order dispatchOrder(Order o)
    {
        if(o.getPayment()) {
            o.setStatus("dispatched");
            System.out.println(o.getOrderName()+ "has dispatched");
        }
        else
        {
            System.out.println(o.getOrderName()+" is not dispatched");
        }
        return o;
    }

    static Order getPayment(Order o)  {
            try {
                if(!o.getPayment()) {
                    Thread.sleep(3000);
                    o.setPayment(true);
                    System.out.println(o.getOrderName()+ "has payment done");
                }
                else{
                    System.out.println(o.getOrderName()+ "has payment not done");
                    o.setStatus("payment failed");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        return o;
    }

    static Order sendMail(Order o)
    {
        if(o.getPayment() && o.getStatus().equalsIgnoreCase("dispatched")) {
            o.setSendMail("Order  send");
            System.out.println(o.getOrderName() + " dispatch mail send");
        }
        return o;
    }

}