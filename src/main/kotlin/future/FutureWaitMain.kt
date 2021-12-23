import java.lang.Thread.sleep
import java.util.concurrent.Executors


fun main(args: Array<String>) {
  val executor = Executors.newSingleThreadExecutor()
  val future = executor.submit<String> {
    sleep(1000 * 2)
    "Done"
  }

  while (!future.isDone) {
    sleep(100)
  }

  println(future.get())

  executor.shutdown()
}