// Archivo: pruebas.sc
// Objeto a probar
import Anagramas._

println("-------------------------------------------------")
println("--- Pruebas para el objeto Anagramas ---")
println("-------------------------------------------------")
println(s"Diccionario utilizado: ${diccionario.mkString(", ")}")
println("=============================================")
println("===        Pruebas para lOcPal          ===")
println("=============================================")

// --- Caso 1: Palabra vacía ---
val pal1 = ""
val esperado1 = List()
val resultado1 = lOcPal(pal1)
println(s"Test 1: Palabra vacía")
println(s"  Palabra:   '$pal1'")
println(s"  Esperado:  $esperado1")
println(s"  Resultado: $resultado1")
println(s"  Correcto: ${resultado1 == esperado1}")
println("-" * 20)

// --- Caso 2: Palabra simple minúscula ---
val pal2 = "roca"
val esperado2 = List(('a', 1), ('c', 1), ('o', 1), ('r', 1))
val resultado2 = lOcPal(pal2)
println(s"Test 2: Palabra simple minúscula")
println(s"  Palabra:   '$pal2'")
println(s"  Esperado:  $esperado2")
println(s"  Resultado: $resultado2")
println(s"  Correcto: ${resultado2 == esperado2}")
println("-" * 20)

// --- Caso 3: Palabra con mayúsculas y minúsculas ---
val pal3 = "OcaSos"
val esperado3 = List(('a', 1), ('c', 1), ('o', 2), ('s', 2)) // Debe convertir a minúsculas y contar
val resultado3 = lOcPal(pal3)
println(s"Test 3: Palabra con mayúsculas/minúsculas")
println(s"  Palabra:   '$pal3'")
println(s"  Esperado:  $esperado3")
println(s"  Resultado: $resultado3")
println(s"  Correcto: ${resultado3 == esperado3}")
println("-" * 20)

// --- Caso 4: Palabra con letras repetidas y desordenadas ---
val pal4 = "mocosos"
val esperado4 = List(('c', 1), ('m', 1), ('o', 3), ('s', 2)) // Debe ordenar por caracter
val resultado4 = lOcPal(pal4)
println(s"Test 4: Palabra con repeticiones y desorden")
println(s"  Palabra:   '$pal4'")
println(s"  Esperado:  $esperado4")
println(s"  Resultado: $resultado4")
println(s"  Correcto: ${resultado4 == esperado4}")
println("-" * 20)

// --- Caso 5: Palabra con un solo tipo de letra repetida ---
val pal5 = "sss"
val esperado5 = List(('s', 3))
val resultado5 = lOcPal(pal5)
println(s"Test 5: Palabra con una sola letra repetida")
println(s"  Palabra:   '$pal5'")
println(s"  Esperado:  $esperado5")
println(s"  Resultado: $resultado5")
println(s"  Correcto: ${resultado5 == esperado5}")
println("-" * 20)


println("=============================================")
println("===        Pruebas para lOcFrase        ===")
println("=============================================")

// --- Caso 1: Frase vacía ---
val frase1 : Frase = List()
val esperadoF1 = List()
val resultadoF1 = lOcFrase(frase1)
println(s"Test 1: Frase vacía")
println(s"  Frase:     $frase1")
println(s"  Esperado:  $esperadoF1")
println(s"  Resultado: $resultadoF1")
println(s"  Correcto: ${resultadoF1 == esperadoF1}")
println("-" * 20)

// --- Caso 2: Frase con una sola palabra ---
val frase2 : Frase = List("Ocasos") // Misma que pal3 de lOcPal
val esperadoF2 = List(('a', 1), ('c', 1), ('o', 2), ('s', 2))
val resultadoF2 = lOcFrase(frase2)
println(s"Test 2: Frase con una palabra")
println(s"  Frase:     $frase2")
println(s"  Esperado:  $esperadoF2")
println(s"  Resultado: $resultadoF2")
println(s"  Correcto: ${resultadoF2 == esperadoF2}")
println("-" * 20)

// --- Caso 3: Frase con múltiples palabras ---
val frase3 : Frase = List("Yo", "como", "roca")
val esperadoF3 = List(('a', 1), ('c', 2), ('m', 1), ('o', 4), ('r', 1), ('y', 1)) // yocomoroca -> a:1, c:2, m:1, o:4, r:1, y:1
val resultadoF3 = lOcFrase(frase3)
println(s"Test 3: Frase con múltiples palabras")
println(s"  Frase:     $frase3")
println(s"  Esperado:  $esperadoF3")
println(s"  Resultado: $resultadoF3")
println(s"  Correcto: ${resultadoF3 == esperadoF3}")
println("-" * 20)

// --- Caso 4: Frase con palabras repetidas y mayúsculas ---
val frase4 : Frase = List("Moco", "moco", "SOS")
val esperadoF4 = List(('c', 2), ('m', 2), ('o', 5), ('s', 2)) // mocomocosos -> c:2, m:2, o:5, s:2
val resultadoF4 = lOcFrase(frase4)
println(s"Test 4: Frase con repeticiones y mayúsculas")
println(s"  Frase:     $frase4")
println(s"  Esperado:  $esperadoF4")
println(s"  Resultado: $resultadoF4")
println(s"  Correcto: ${resultadoF4 == esperadoF4}")
println("-" * 20)

// --- Caso 5: Frase con palabra vacía incluida ---
val frase5 : Frase = List("yo", "", "y", "oca")
val esperadoF5 = List(('a', 1), ('c', 1), ('o', 2), ('y', 2)) // yoyoca -> a:1, c:1, o:2, y:2
val resultadoF5 = lOcFrase(frase5)
println(s"Test 5: Frase con palabra vacía")
println(s"  Frase:     $frase5")
println(s"  Esperado:  $esperadoF5")
println(s"  Resultado: $resultadoF5")
println(s"  Correcto: ${resultadoF5 == esperadoF5}")
println("-" * 20)


println("=============================================")
println("===   Pruebas para anagramasDePalabra   ===")
println("=============================================")
// Depende del `diccionario` y `diccionarioPorOcurrencias`

// --- Caso 1: Palabra con anagramas en el diccionario ---
val palAna1 = "oca"
val esperadoAna1 = List("oca", "cayo") // Ambas tienen List(('a', 1), ('c', 1), ('o', 1))
val resultadoAna1 = anagramasDePalabra(palAna1).sorted // Ordenar para comparación consistente
println(s"Test 1: Palabra con anagramas")
println(s"  Palabra:   '$palAna1'")
println(s"  Esperado:  $esperadoAna1")
println(s"  Resultado: $resultadoAna1")
println(s"  Correcto: ${resultadoAna1 == esperadoAna1}")
println("-" * 20)

// --- Caso 2: Palabra con anagramas (búsqueda insensible a mayúsculas) ---
val palAna2 = "CaYo" // Misma ocurrencia que "oca"
val esperadoAna2 = List("oca", "cayo")
val resultadoAna2 = anagramasDePalabra(palAna2).sorted
println(s"Test 2: Palabra con anagramas (insensible a mayúsculas)")
println(s"  Palabra:   '$palAna2'")
println(s"  Esperado:  $esperadoAna2")
println(s"  Resultado: $resultadoAna2")
println(s"  Correcto: ${resultadoAna2 == esperadoAna2}")
println("-" * 20)

// --- Caso 3: Palabra sin anagramas en el diccionario ---
val palAna3 = "hola"
val esperadoAna3 = Nil
val resultadoAna3 = anagramasDePalabra(palAna3)
println(s"Test 3: Palabra sin anagramas")
println(s"  Palabra:   '$palAna3'")
println(s"  Esperado:  $esperadoAna3")
println(s"  Resultado: $resultadoAna3")
println(s"  Correcto: ${resultadoAna3 == esperadoAna3}")
println("-" * 20)

// --- Caso 4: Palabra vacía ---
val palAna4 = ""
val esperadoAna4 = Nil // Ocurrencia es List(), no debería estar en el Map (a menos que "" esté en diccionario)
val resultadoAna4 = anagramasDePalabra(palAna4)
println(s"Test 4: Palabra vacía")
println(s"  Palabra:   '$palAna4'")
println(s"  Esperado:  $esperadoAna4")
println(s"  Resultado: $resultadoAna4")
println(s"  Correcto: ${resultadoAna4 == esperadoAna4}")
println("-" * 20)

// --- Caso 5: Palabra que es anagrama de sí misma y otras ---
val palAna5 = "moco"
val esperadoAna5 = List("como", "moco") // Ambas tienen List(('c', 1), ('m', 1), ('o', 2))
val resultadoAna5 = anagramasDePalabra(palAna5).sorted
println(s"Test 5: Palabra con anagramas (incluida ella misma)")
println(s"  Palabra:   '$palAna5'")
println(s"  Esperado:  $esperadoAna5")
println(s"  Resultado: $resultadoAna5")
println(s"  Correcto: ${resultadoAna5 == esperadoAna5}")
println("-" * 20)


println("=============================================")
println("===      Pruebas para combinaciones     ===")
println("=============================================")
// Nota: La función devuelve una lista de ocurrencias, incluyendo la lista vacía.

// --- Caso 1: Lista de ocurrencias vacía ---
val ocComb1: Ocurrencias = List()
val esperadoComb1: List[Ocurrencias] = List(List())
val resultadoComb1 = combinaciones(ocComb1)
println(s"Test 1: Lista vacía")
println(s"  Ocurrencias: $ocComb1")
println(s"  Esperado:    $esperadoComb1")
println(s"  Resultado:   $resultadoComb1")
// Comparar sets por si el orden varía, aunque la función debería ser determinista
println(s"  Correcto:    ${resultadoComb1.toSet == esperadoComb1.toSet}")
println("-" * 20)

// --- Caso 2: Un caracter, una ocurrencia ---
val ocComb2: Ocurrencias = List(('a', 1))
val esperadoComb2: List[Ocurrencias] = List(List(), List(('a', 1)))
val resultadoComb2 = combinaciones(ocComb2)
println(s"Test 2: Un caracter, una ocurrencia")
println(s"  Ocurrencias: $ocComb2")
println(s"  Esperado:    $esperadoComb2")
println(s"  Resultado:   $resultadoComb2")
println(s"  Correcto:    ${resultadoComb2.toSet == esperadoComb2.toSet}")
println("-" * 20)

// --- Caso 3: Un caracter, múltiples ocurrencias ---
val ocComb3: Ocurrencias = List(('a', 2))
val esperadoComb3: List[Ocurrencias] = List(List(), List(('a', 1)), List(('a', 2)))
val resultadoComb3 = combinaciones(ocComb3)
println(s"Test 3: Un caracter, múltiples ocurrencias")
println(s"  Ocurrencias: $ocComb3")
println(s"  Esperado:    $esperadoComb3")
println(s"  Resultado:   $resultadoComb3")
println(s"  Correcto:    ${resultadoComb3.toSet == esperadoComb3.toSet}")
println("-" * 20)

// --- Caso 4: Múltiples caracteres, una ocurrencia cada uno ---
val ocComb4: Ocurrencias = List(('a', 1), ('b', 1))
val esperadoComb4: List[Ocurrencias] = List(
  List(),
  List(('b', 1)),
  List(('a', 1)),
  List(('a', 1), ('b', 1)) // Ordenado por la función interna
).map(_.sorted) // Asegurar orden interno para comparar
val resultadoComb4 = combinaciones(ocComb4).map(_.sorted) // Ordenar interno
println(s"Test 4: Múltiples caracteres, una ocurrencia")
println(s"  Ocurrencias: $ocComb4")
println(s"  Esperado:    ${esperadoComb4.map(l => l.toString)}") // Imprimir como string para legibilidad
println(s"  Resultado:   ${resultadoComb4.map(l => l.toString)}")
// Comparar sets de listas convertidas a sets para ignorar orden externo
println(s"  Correcto:    ${resultadoComb4.map(_.toSet).toSet == esperadoComb4.map(_.toSet).toSet}")
println("-" * 20)


// --- Caso 5: Múltiples caracteres, múltiples ocurrencias ---
val ocComb5: Ocurrencias = List(('a', 2), ('b', 1))
val esperadoComb5: List[Ocurrencias] = List(
  List(),
  List(('b', 1)), // Combinaciones de ('b', 1)
  List(('a', 1)), // Combinaciones de ('a', 2) añadidas
  List(('a', 2)),
  List(('a', 1), ('b', 1)), // Combinaciones ('a', k) ++ combs(rest)
  List(('a', 2), ('b', 1))
).map(_.sorted)
val resultadoComb5 = combinaciones(ocComb5).map(_.sorted)
println(s"Test 5: Múltiples caracteres y ocurrencias")
println(s"  Ocurrencias: $ocComb5")
println(s"  Esperado:    ${esperadoComb5.map(l => l.toString)}")
println(s"  Resultado:   ${resultadoComb5.map(l => l.toString)}")
println(s"  Correcto:    ${resultadoComb5.map(_.toSet).toSet == esperadoComb5.map(_.toSet).toSet}")
println("-" * 20)


println("=============================================")
println("===       Pruebas para complemento      ===")
println("=============================================")

// --- Caso 1: Complemento con subconjunto vacío ---
val ocComp1: Ocurrencias = List(('a', 2), ('b', 1))
val subOcComp1: Ocurrencias = List()
val esperadoComp1: Ocurrencias = List(('a', 2), ('b', 1))
val resultadoComp1 = complemento(ocComp1, subOcComp1)
println(s"Test 1: Complemento con subconjunto vacío")
println(s"  Ocurrencias: $ocComp1")
println(s"  Subconjunto: $subOcComp1")
println(s"  Esperado:    $esperadoComp1")
println(s"  Resultado:   $resultadoComp1")
println(s"  Correcto:    ${resultadoComp1 == esperadoComp1}")
println("-" * 20)

// --- Caso 2: Complemento con subconjunto idéntico ---
val ocComp2: Ocurrencias = List(('a', 2), ('b', 1))
val subOcComp2: Ocurrencias = List(('a', 2), ('b', 1))
val esperadoComp2: Ocurrencias = List()
val resultadoComp2 = complemento(ocComp2, subOcComp2)
println(s"Test 2: Complemento con subconjunto idéntico")
println(s"  Ocurrencias: $ocComp2")
println(s"  Subconjunto: $subOcComp2")
println(s"  Esperado:    $esperadoComp2")
println(s"  Resultado:   $resultadoComp2")
println(s"  Correcto:    ${resultadoComp2 == esperadoComp2}")
println("-" * 20)

// --- Caso 3: Complemento parcial (un caracter) ---
val ocComp3: Ocurrencias = List(('a', 3), ('b', 2), ('c', 1))
val subOcComp3: Ocurrencias = List(('a', 1))
val esperadoComp3: Ocurrencias = List(('a', 2), ('b', 2), ('c', 1))
val resultadoComp3 = complemento(ocComp3, subOcComp3)
println(s"Test 3: Complemento parcial (un caracter)")
println(s"  Ocurrencias: $ocComp3")
println(s"  Subconjunto: $subOcComp3")
println(s"  Esperado:    $esperadoComp3")
println(s"  Resultado:   $resultadoComp3")
println(s"  Correcto:    ${resultadoComp3 == esperadoComp3}")
println("-" * 20)

// --- Caso 4: Complemento parcial (múltiples caracteres, resta total de uno) ---
val ocComp4: Ocurrencias = List(('a', 3), ('b', 2), ('c', 1))
val subOcComp4: Ocurrencias = List(('a', 2), ('c', 1))
val esperadoComp4: Ocurrencias = List(('a', 1), ('b', 2))
val resultadoComp4 = complemento(ocComp4, subOcComp4)
println(s"Test 4: Complemento parcial (múltiples caracteres)")
println(s"  Ocurrencias: $ocComp4")
println(s"  Subconjunto: $subOcComp4")
println(s"  Esperado:    $esperadoComp4")
println(s"  Resultado:   $resultadoComp4")
println(s"  Correcto:    ${resultadoComp4 == esperadoComp4}")
println("-" * 20)

// --- Caso 5: Complemento donde el subconjunto tiene caracteres no presentes en el original ---
// La función debería ignorar esos caracteres extra en el subconjunto
val ocComp5: Ocurrencias = List(('a', 2), ('c', 3))
val subOcComp5: Ocurrencias = List(('a', 1), ('b', 1), ('c', 2)) // 'b' no está en ocComp5
val esperadoComp5: Ocurrencias = List(('a', 1), ('c', 1))
val resultadoComp5 = complemento(ocComp5, subOcComp5)
println(s"Test 5: Subconjunto con caracteres extra")
println(s"  Ocurrencias: $ocComp5")
println(s"  Subconjunto: $subOcComp5")
println(s"  Esperado:    $esperadoComp5")
println(s"  Resultado:   $resultadoComp5")
println(s"  Correcto:    ${resultadoComp5 == esperadoComp5}")
println("-" * 20)


println("=============================================")
println("===    Pruebas para anagramasDeFrase    ===")
println("=============================================")
// Esta es la función más compleja, combina las demás.

// --- Caso 1: Frase vacía ---
val fraseAna1: Frase = List()
val esperadoAnaF1: List[Frase] = List(List())
val resultadoAnaF1 = anagramasDeFrase(fraseAna1)
println(s"Test 1: Frase vacía")
println(s"  Frase:     $fraseAna1")
println(s"  Esperado:  $esperadoAnaF1")
println(s"  Resultado: $resultadoAnaF1")
println(s"  Correcto:  ${resultadoAnaF1 == esperadoAnaF1}")
println("-" * 20)

// --- Caso 2: Frase que forma una palabra del diccionario ---
val fraseAna2: Frase = List("Roca") // lOcFrase -> List(('a', 1), ('c', 1), ('o', 1), ('r', 1))
val esperadoAnaF2: List[Frase] = List(List("roca")) // Solo "roca" tiene esas ocurrencias
val resultadoAnaF2 = anagramasDeFrase(fraseAna2)
println(s"Test 2: Frase forma una palabra del diccionario")
println(s"  Frase:     $fraseAna2")
println(s"  Esperado:  $esperadoAnaF2")
println(s"  Resultado: $resultadoAnaF2")
// Comparar sets por si el orden de las frases varía
println(s"  Correcto:  ${resultadoAnaF2.map(_.toSet).toSet == esperadoAnaF2.map(_.toSet).toSet}")
println("-" * 20)

// --- Caso 3: Frase cuyas letras forman anagramas de una palabra ---
val fraseAna3: Frase = List("Oca") // lOcFrase -> List(('a', 1), ('c', 1), ('o', 1))
val esperadoAnaF3: List[Frase] = List(List("oca"), List("cayo")) // Palabras con esas ocurrencias
val resultadoAnaF3 = anagramasDeFrase(fraseAna3)
println(s"Test 3: Frase forma anagramas de una palabra")
println(s"  Frase:     $fraseAna3")
println(s"  Esperado:  ${esperadoAnaF3.map(_.toString)}")
println(s"  Resultado: ${resultadoAnaF3.map(_.toString)}")
println(s"  Correcto:  ${resultadoAnaF3.map(_.toSet).toSet == esperadoAnaF3.map(_.toSet).toSet}")
println("-" * 20)

// --- Caso 4: Frase forma anagramas de múltiples palabras ---
val fraseAna4: Frase = List("Yo", "Roca") // lOcFrase -> List(('a', 1), ('c', 1), ('o', 2), ('r', 1), ('y', 1))
val esperadoAnaF4: List[Frase] = List(List("roca", "yo"), List("yo", "roca"))
val resultadoAnaF4 = anagramasDeFrase(fraseAna4)
println(s"Test 4: Frase forma anagramas de múltiples palabras")
println(s"  Frase:     $fraseAna4")
println(s"  Esperado:  ${esperadoAnaF4.map(_.toString)}")
println(s"  Resultado: ${resultadoAnaF4.map(_.toString)}")
println(s"  Correcto:  ${resultadoAnaF4.map(_.toSet).toSet == esperadoAnaF4.map(_.toSet).toSet}")
println("-" * 20)

// --- Caso 5: Frase sin anagramas posibles con el diccionario ---
val fraseAna5: Frase = List("Scala") // lOcFrase -> List(('a', 2), ('c', 1), ('l', 1), ('s', 1))
val esperadoAnaF5: List[Frase] = List() // No hay combinaciones de palabras en diccionario con esas letras
val resultadoAnaF5 = anagramasDeFrase(fraseAna5)
println(s"Test 5: Frase sin anagramas posibles")
println(s"  Frase:     $fraseAna5")
println(s"  Esperado:  $esperadoAnaF5")
println(s"  Resultado: $resultadoAnaF5")
println(s"  Correcto:  ${resultadoAnaF5 == esperadoAnaF5}")
println("-" * 20)

// --- Caso 6 (Adicional): Frase más compleja ---
val fraseAna6: Frase = List("como", "yo", "y") // lOcFrase -> List(('c', 1), ('m', 1), ('o', 3), ('y', 2))
// Posibles combinaciones: List("como", "yo", "y"), List("como", "y", "yo"),
//                     List("moco", "yo", "y"), List("moco", "y", "yo"),
//                     List("yo", "como", "y"), List("yo", "moco", "y"), List("yo", "y", "como"), List("yo", "y", "moco")
//                     List("y", "yo", "como"), List("y", "yo", "moco"), List("y", "como", "yo"), List("y", "moco", "yo")
//                     Otras? como:('c',1),('m',1),('o',2), moco:('c',1),('m',1),('o',2), yo:('o',1),('y',1), y:('y',1)
//                     ('c', 1), ('m', 1), ('o', 3), ('y', 2)
//                     1. como ('c',1),('m',1),('o',2) -> resto ('o',1),('y',2) -> yo ('o',1),('y',1) -> resto ('y',1) -> y ('y',1) -> resto () => List("como", "yo", "y")
//                     1. bis -> resto ('o',1),('y',2) -> y ('y',1) -> resto ('o',1),('y',1) -> yo ('o',1),('y',1) -> resto () => List("como", "y", "yo")
//                     2. moco ('c',1),('m',1),('o',2) -> resto ('o',1),('y',2) -> yo ('o',1),('y',1) -> resto ('y',1) -> y ('y',1) -> resto () => List("moco", "yo", "y")
//                     2. bis -> resto ('o',1),('y',2) -> y ('y',1) -> resto ('o',1),('y',1) -> yo ('o',1),('y',1) -> resto () => List("moco", "y", "yo")
//                     3. yo ('o',1),('y',1) -> resto ('c',1),('m',1),('o',2),('y',1) -> como ('c',1),('m',1),('o',2) -> resto ('y',1) -> y ('y',1) -> resto () => List("yo", "como", "y")
//                     3. bis -> resto ('c',1),('m',1),('o',2),('y',1) -> moco ('c',1),('m',1),('o',2) -> resto ('y',1) -> y ('y',1) -> resto () => List("yo", "moco", "y")
//                     3. ter -> resto ('c',1),('m',1),('o',2),('y',1) -> y ('y',1) -> resto ('c',1),('m',1),('o',2) -> como (...) -> resto () => List("yo", "y", "como")
//                     3. quat -> resto ('c',1),('m',1),('o',2),('y',1) -> y ('y',1) -> resto ('c',1),('m',1),('o',2) -> moco (...) -> resto () => List("yo", "y", "moco")
//                     4. y ('y',1) -> resto ('c',1),('m',1),('o',3),('y',1) -> como ('c',1),('m',1),('o',2) -> resto ('o',1),('y',1) -> yo (...) -> resto () => List("y", "como", "yo")
//                     4. bis -> resto ('c',1),('m',1),('o',3),('y',1) -> moco ('c',1),('m',1),('o',2) -> resto ('o',1),('y',1) -> yo (...) -> resto () => List("y", "moco", "yo")
//                     4. ter -> resto ('c',1),('m',1),('o',3),('y',1) -> yo ('o',1),('y',1) -> resto ('c',1),('m',1),('o',2) -> como (...) -> resto () => List("y", "yo", "como")
//                     4. quat -> resto ('c',1),('m',1),('o',3),('y',1) -> yo ('o',1),('y',1) -> resto ('c',1),('m',1),('o',2) -> moco (...) -> resto () => List("y", "yo", "moco")
val esperadoAnaF6: List[Frase] = List(
  List("como", "yo", "y"), List("como", "y", "yo"),
  List("moco", "yo", "y"), List("moco", "y", "yo"),
  List("yo", "como", "y"), List("yo", "moco", "y"), List("yo", "y", "como"), List("yo", "y", "moco"),
  List("y", "como", "yo"), List("y", "moco", "yo"), List("y", "yo", "como"), List("y", "yo", "moco")
)
val resultadoAnaF6 = anagramasDeFrase(fraseAna6)
println(s"Test 6: Frase más compleja")
println(s"  Frase:     $fraseAna6")
println(s"  Esperado (conteo): ${esperadoAnaF6.length}")
println(s"  Resultado (conteo): ${resultadoAnaF6.length}")
println(s"  Esperado (muestra): ${esperadoAnaF6.headOption.getOrElse(List()).toString}")
println(s"  Resultado (muestra): ${resultadoAnaF6.headOption.getOrElse(List()).toString}")
// Comparar sets para ignorar el orden de las frases resultado
println(s"  Correcto:  ${resultadoAnaF6.map(_.toSet).toSet == esperadoAnaF6.map(_.toSet).toSet}")
println("-" * 20)


println("=============================================")
println("===    Fin de las pruebas Anagramas     ===")
println("=============================================")