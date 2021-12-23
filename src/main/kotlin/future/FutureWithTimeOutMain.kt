import java.lang.Thread.sleep
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit


fun main(args: Array<String>) {
  val executor = Executors.newSingleThreadExecutor()
  val future = executor.submit<String> {
    sleep(1000 * 2)
    "Done"
  }

  // This method get blocks the execution after 1 second.
  // If task didn't complete, it will throw TimeoutException
  println(future.get(1, TimeUnit.SECONDS))

  executor.shutdown()
}