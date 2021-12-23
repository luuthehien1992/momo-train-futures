import java.lang.Thread.sleep
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors


fun main(args: Array<String>) {
  val executor = Executors.newSingleThreadExecutor()
  val completableFuture = CompletableFuture<String>()

  executor.submit{
    sleep(1000 * 2)
    completableFuture.complete("Done")
  }

  // Method get blocks the execution until the task is complete
  println(completableFuture.get())

  executor.shutdown()
}