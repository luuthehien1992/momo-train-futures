import java.lang.Thread.sleep
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors


fun main(args: Array<String>) {
  val executor = Executors.newWorkStealingPool(2)
  val completableFuture = CompletableFuture.supplyAsync({
    "Hello"
  }, executor)

  val future = completableFuture.thenApply {
    "$it World"
  }

  // Method get blocks the execution until the task is complete
  println(future.get())

  executor.shutdown()
}