import java.util.concurrent.Executors

object TenThousandNamePrinter extends App{

  val es = Executors.newFixedThreadPool(10)
  for(i <- 1 to 10000) yield {
    es.submit(new Runnable {
      override def run(): Unit = {
        Thread.sleep(1000)
        println(Thread.currentThread().getName)
      }
    })
  }


}
