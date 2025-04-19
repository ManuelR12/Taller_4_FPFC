import Anagramas._

// -------------------------------
// Pruebas de lOcPal
// -------------------------------
lOcPal("Casa")               // Esperado: List(('a', 2), ('c', 1), ('s', 1))
lOcPal("moco")               // Esperado: List(('c', 1), ('m', 1), ('o', 2))

// -------------------------------
// Pruebas de lOcFrase
// -------------------------------
lOcFrase(List("El", "Sol"))  // Esperado: List(('e', 1), ('l', 2), ('o', 1), ('s', 1))
lOcFrase(List("yo", "y"))    // Esperado: List(('o', 1), ('y', 2))

// -------------------------------
// Pruebas de diccionarioPorOcurrencias
// -------------------------------
diccionarioPorOcurrencias    // Imprime el mapa completo agrupando por ocurrencias

// -------------------------------
// Pruebas de anagramasDePalabra
// -------------------------------
anagramasDePalabra("ocasos") // Puede devolver List("cosas", "ocasos")
anagramasDePalabra("moco")   // Puede devolver List("moco", "como") dependiendo del diccionario

// -------------------------------
// Pruebas de combinaciones
// -------------------------------
combinaciones(List(('a', 2), ('b', 1)))
/*
Esperado (orden no importa):
List(
  List(),
  List(('a', 1)),
  List(('a', 2)),
  List(('b', 1)),
  List(('a', 1), ('b', 1)),
  List(('a', 2), ('b', 1))
)
*/

// -------------------------------
// Pruebas de complemento
// -------------------------------
complemento(
  List(('a', 2), ('b', 1), ('c', 1)),
  List(('a', 1), ('c', 1))
) // Esperado: List(('a', 1), ('b', 1))

// -------------------------------
// Pruebas de anagramasDeFrase
// -------------------------------
val frase = List("cosas", "como", "yo")
anagramasDeFrase(frase) // Ej: List(List("yo", "como", "cosas"), List("cayo", "mocosos"), ...)
