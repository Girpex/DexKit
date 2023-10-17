import org.luckypray.dexkit.DexKitBridge
import org.luckypray.dexkit.query.enums.StringMatchType
import java.io.File
import java.util.Locale

val isWindows
    get() = System.getProperty("os.name")
        .lowercase(Locale.getDefault())
        .contains("windows")

@Suppress("UnsafeDynamicallyLoadedCode")
fun loadLibrary(name: String) {
    try {
        System.loadLibrary(if (isWindows) "lib$name" else name)
    } catch (e: UnsatisfiedLinkError) {
        val libraryPath = File("main/build/library")
        libraryPath.listFiles()?.forEach {
            if (it.name.startsWith("lib$name")) {
                System.load(it.absolutePath)
            }
        }
    }
}

fun main() {
    loadLibrary("dexkit")
    println("current work dir: ${File("").absolutePath}")
    val file = File("apk/QQ_8.9.70_clone.apk")
    if (!file.exists()) {
        println("apk not found")
        return
    }
    doSearch(file.absolutePath)
}

fun doSearch(path: String) {
    val createTime = System.currentTimeMillis()
    var releaseTime = 0L
    DexKitBridge.create(path)?.use { bridge ->
        println("create use time: ${System.currentTimeMillis() - createTime}ms")
        val startTime = System.currentTimeMillis()
        search(bridge)
        println("find use time: ${System.currentTimeMillis() - startTime}ms")
        releaseTime = System.currentTimeMillis()
    }
    println("release use time: ${System.currentTimeMillis() - releaseTime}ms")
}

fun search(bridge: DexKitBridge) {
    val method = bridge.findMethod {
        matcher {
            usingStrings("xxxxx")
            paramCount = 3
        }
    }.first()
    bridge.findMethod {
        matcher {
            declaredClass = "xxxxx"
            returnType = "boolean"
            paramTypes()
            addCall {
                declaredClass = method.className
                returnType = method.returnTypeName
            }
        }
    }
}


