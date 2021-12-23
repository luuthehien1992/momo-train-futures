import java.lang.Thread.sleep
import java.util.concurrent.Executors


fun main(args: Array<String>) {
  val executor = Executors.newWorkStealingPool(2)
  val future1 = executor.submit<String> {
    println("Do task 1")
    sleep(1000 * 2)
    println("Done task 1")
    "Done 1"
  }
  val future2 = executor.submit<String> {
    println("Do task 2")
    sleep(1000 * 2)
    println("Done task 2")
    "Done 2"
  }

  // Method get blocks the execution until the task is complete
  println(future1.get())
  println(future2.get())

  executor.shutdown()
}