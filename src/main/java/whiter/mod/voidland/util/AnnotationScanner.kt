package whiter.mod.voidland.util

import java.io.File
import java.io.IOException
import java.net.JarURLConnection
import java.net.URL
import java.net.URLDecoder
import java.util.*
import java.util.jar.JarFile
import kotlin.collections.HashSet


object AnnotationScanner {
    @Throws(Exception::class)
    fun getClasses(packageName: String): Set<Class<*>> {
        var packageName = packageName

        // 第一个class类的集合
        //List<Class<?>> classes = new ArrayList<Class<?>>();
        val classes = HashSet<Class<*>>()

        // 是否循环迭代
        val recursive = true
        // 获取包的名字 并进行替换
        val packageDirName = packageName.replace('.', '/')
        // 定义一个枚举的集合 并进行循环来处理这个目录下的things
        val dirs: Enumeration<URL>
        try {
            dirs = Thread.currentThread().contextClassLoader.getResources(packageDirName)
            // 循环迭代下去
            while (dirs.hasMoreElements()) {
                // 获取下一个元素
                val url = dirs.nextElement()
                // 得到协议的名称
                val protocol = url.getProtocol()
                // 如果是以文件的形式保存在服务器上
                if ("file" == protocol) {
                    // 获取包的物理路径
                    val filePath = URLDecoder.decode(url.getFile(), "UTF-8")
                    // 以文件的方式扫描整个包下的文件 并添加到集合中
                    addClass(classes, filePath, packageName)
                } else if ("jar" == protocol) {
                    // 如果是jar包文件
                    // 定义一个JarFile
                    val jar: JarFile
                    try {
                        // 获取jar
                        jar = (url.openConnection() as JarURLConnection).jarFile
                        // 从此jar包 得到一个枚举类
                        val entries = jar.entries()
                        // 同样的进行循环迭代
                        while (entries.hasMoreElements()) {
                            // 获取jar里的一个实体 可以是目录 和一些jar包里的其他文件 如META-INF等文件
                            val entry = entries.nextElement()
                            var name = entry.name
                            // 如果是以/开头的
                            if (name[0] == '/') {
                                // 获取后面的字符串
                                name = name.substring(1)
                            }
                            // 如果前半部分和定义的包名相同
                            if (name.startsWith(packageDirName)) {
                                val idx = name.lastIndexOf('/')
                                // 如果以"/"结尾 是一个包
                                if (idx != -1) {
                                    // 获取包名 把"/"替换成"."
                                    packageName = name.substring(0, idx).replace('/', '.')
                                }
                                // 如果可以迭代下去 并且是一个包
                                if (idx != -1 || recursive) {
                                    // 如果是一个.class文件 而且不是目录
                                    if (name.endsWith(".class") && !entry.isDirectory) {
                                        // 去掉后面的".class" 获取真正的类名
                                        val className = name.substring(packageName.length + 1, name.length - 6)
                                        try {
                                            // 添加到classes
                                            classes.add(Class.forName("$packageName.$className"))
                                        } catch (e: ClassNotFoundException) {
                                            e.printStackTrace()
                                        }

                                    }
                                }
                            }
                        }
                    } catch (e: IOException) {
                        e.printStackTrace()
                    }

                }
            }
        } catch (e: IOException) {
            e.printStackTrace()
        }

        return classes
    }

    @Throws(Exception::class)
    fun addClass(classes: MutableSet<Class<*>>, filePath: String, packageName: String) {
        val files = File(filePath).listFiles { file -> file.isFile && file.name.endsWith(".class") || file.isDirectory }!!
        for (file in files) {
            val fileName = file.name
            if (file.isFile) {
                var classsName = fileName.substring(0, fileName.lastIndexOf("."))
                if (packageName.isNotEmpty()) {
                    classsName = "$packageName.$classsName"
                }
                doAddClass(classes, classsName)
            }

        }
    }

    @Throws(Exception::class)
    fun doAddClass(classes: MutableSet<Class<*>>, classsName: String) {
        //Class.forName 也可以
        val classLoader = object : ClassLoader() {
            @Throws(ClassNotFoundException::class)
            override fun loadClass(name: String): Class<*> {
                return super.loadClass(name)
            }
        }
        classes.add(classLoader.loadClass(classsName))
    }

    @Throws(Exception::class)
    fun <A : Annotation> getAnnotationClasses(packageName: String, annotationClass: Class<A>): Set<Class<*>> {

        //找用了annotationClass注解的类
        val controllers = HashSet<Class<*>>()
        val clsList = getClasses(packageName)

        if (clsList.isNotEmpty()) {
            for (cls in clsList) {
                if (cls.getAnnotation(annotationClass) != null) {
                    controllers.add(cls)
                }
            }
        }
        return controllers
    }
}