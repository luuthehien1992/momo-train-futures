import java.lang.Thread.sleep
import java.util.concurrent.CompletableFuture
import java.util.concurrent.Executors


fun main(args: Array<String>) {
  val executor = Executors.newWorkStealingPool(2)
  val completableFuture = CompletableFuture.supplyAsync({
    "Hello"
  }, executor)

  completableFuture.thenAccept {
    println("$it World")
  }

  sleep(1000)

  executor.shutdown()
}