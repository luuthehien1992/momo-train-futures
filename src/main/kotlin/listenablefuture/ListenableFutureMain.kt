import com.google.common.util.concurrent.FutureCallback
import com.google.common.util.concurrent.Futures
import java.lang.Thread.sleep
import java.util.concurrent.Executors
import kotlin.concurrent.fixedRateTimer


fun main(args: Array<String>) {
  val executor = Executors.newWorkStealingPool(2)
  val future = Futures.submit<String>({
    "Done"
  }, executor)

  println(future.get())

  executor.shutdown()
}