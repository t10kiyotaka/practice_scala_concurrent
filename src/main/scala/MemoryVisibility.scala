object MemoryVisibility extends App {

  var number = 0
  var ready = false
  private[this] def getNumber: Int = synchronized { number }
  private[this] def getReady: Boolean = synchronized { ready }

  new Thread(() => {
    while(!getReady) {
      Thread.`yield`()
    }
    println(getNumber)
  }).start()

//  @volatile var number = 2525
//  @volatile var ready = true

  synchronized {
    number = 2525
    ready = true
  }
}
