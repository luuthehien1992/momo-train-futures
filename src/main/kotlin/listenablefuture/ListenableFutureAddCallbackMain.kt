import com.google.common.util.concurrent.FutureCallback
import com.google.common.util.concurrent.Futures
import java.lang.Thread.sleep
import java.util.concurrent.Executors


fun main(args: Array<String>) {
  val executor = Executors.newWorkStealingPool(2)
  val future = Futures.submit<String>({
    "Done"
  }, executor)

  Futures.addCallback(future, object : FutureCallback<String> {
    override fun onSuccess(result: String) {
      println(result)
    }

    override fun onFailure(t: Throwable) {
    }
  }, executor)

  sleep(1000)

  executor.shutdown()
}