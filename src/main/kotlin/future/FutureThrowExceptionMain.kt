import java.lang.Thread.sleep
import java.util.concurrent.Executors


fun main(args: Array<String>) {
  val executor = Executors.newSingleThreadExecutor()
  val future = executor.submit<String> {
    sleep(1000 * 2)
    throw Exception("Bla bla")
  }

  // This method will raise Exception when task is complete
  println(future.get())

  executor.shutdown()
}