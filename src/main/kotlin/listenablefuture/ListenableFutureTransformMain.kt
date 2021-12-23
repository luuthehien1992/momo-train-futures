import com.google.common.util.concurrent.FutureCallback
import com.google.common.util.concurrent.Futures
import java.lang.Thread.sleep
import java.util.concurrent.Executors


fun main(args: Array<String>) {
  val executor = Executors.newWorkStealingPool(2)
  val future = Futures.submit<String>({
    "Hello"
  }, executor)

  Futures.transform(future, {
    println(it)
  }, executor)

  sleep(1000)

  executor.shutdown()
}