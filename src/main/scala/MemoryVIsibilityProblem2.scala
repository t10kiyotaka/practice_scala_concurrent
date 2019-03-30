object MemoryVisibilityProblem2 extends App {
  var runner = new AsyncRunner1("Runner 0", () => true)

  for (i <- 1 to 10) {
    runner.asyncRun((name) => println(s"${name} is finished."))
    runner = new AsyncRunner1(s"Runner ${i}", runner.canNextStart)
  }

  runner.asyncRun((name) => println(s"${name} is finished. Totally finished."))
}

class AsyncRunner2(private[this] val name: String, private[this] val canStart: () => Boolean) {
  private[this] var isFinished = false

  def asyncRun(f: String => Unit): Unit = {
    new Thread(() => {
      while (!canStart()) {
        Thread.`yield`()
      }
      f(name)
      setIsFinished(false)
    }).start()
  }

  def setIsFinished(bool: Boolean) = synchronized {
    isFinished = bool
  }
  def canNextStart: () => Boolean = () => synchronized{
    this.isFinished
  }
}