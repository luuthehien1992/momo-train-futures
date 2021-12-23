import java.lang.Thread.sleep
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors


fun main(args: Array<String>) {
  val executor = Executors.newSingleThreadExecutor()
  val completableFuture = CompletableFuture<String>()

  executor.submit {
    sleep(1000 * 2)
    completableFuture.completeExceptionally(Exception("Bla Bla"))
  }

  // This method will raise Exception when task is complete
  println(completableFuture.get())

  executor.shutdown()
}