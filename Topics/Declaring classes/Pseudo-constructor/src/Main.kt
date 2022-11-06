class Point3D {
    var x: Int = 0
    var y: Int = 0
    var z: Int = 0
}

fun createPoint(x: Int, y: Int, z: Int): Point3D {
    val newPoint = Point3D()
    newPoint.x = x
    newPoint.y = y
    newPoint.z = z
    return newPoint
}