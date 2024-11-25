package programacionDeServiciosYProcesos.ejercicioLaJoyeria;

public class Enunciado {


//    ACTIVIDAD HILOS PSP
//
//    Un taller de joyería quiere ensamblar tres tipos de collares de perlas: collares blancos, azules o mixtos (combinando perlas alternativamente de ambos colores). Para ello dispone de 5 empleados, y 2 cestos con las perlas –uno para cada color–.
//
//    Codifique en Java las clases Empleado (de tipo hilo), Cesto, Collar, Perla (tiene el atributo color, que podrá setearse desde el constructor) y Joyería, así como el código necesario para simular cómo los empleados montan los collares.
//
//    La clase Joyería contendrá el método main de la aplicación, desde el que se instanciarán los hilos de tipo Empleado, y se lanzará su ejecución. Cuando todos los hilos terminen, desde la función main se imprimirá el número de collares (completos) que se han fabricado. Puede apoyarse en el método isAlive() de la clase Thread para comprobar si un hilo en particular ha finalizado su ejecución. Se recomienda que el hilo principal duerma (1 segundo por ejemplo) entre comprobación y comprobación para ver si los hilos Empleado han terminado.
//    Las unidades que tienen inicialmente los cestos está limitada a 210 perlas azules y 180 blancas. Defina las constantes MAX_BLUE y MAX_WHT
//    Los empleados acceden al método cogerPerla(int color) de los objetos de tipo Cesto, que decrementará el contador de perlas del cesto. Seguidamente invocarán el método insertarPerla(int color) del objeto collar que en ese momento estén fabricando.
//    Todos los collares llevarán 20 perlas, por lo que en todo momento el programa deberá garantizar este requerimiento. Si durante el ensamblado el operador detecta que no hay suficientes perlas para finalizar el collar, deberá lanzar una excepción personalizada, de tipo NoMaterialsLeft. Esta excepción imprimirá el mensaje “Se acabaron las perlas de color XXXXXX”. Implemente también esta clase, que hereda de Exception.
//    El único método que proporcionará la clase Cesto para comprobar si quedan perlas, es el método isMaterialsLeft()




//    Perla: Representa cada perla que se usará en los collares.
//            Métodos: Solo tiene un constructor para definir el color y un método para obtenerlo.
//


//    Cesto: Representa los cestos de perlas.
//    perlasBlancas y perlasAzules: Indican cuántas perlas de cada color hay disponibles.
//    synchronized: Asegura que solo un hilo pueda ejecutar el método a la vez para evitar conflictos al disminuir las perlas.
//    Excepción NoMaterialsLeft: Se lanza si no hay más perlas del color solicitado

//    Collar: Representa un collar en construcción.
//            perlasInsertadas: Lleva el conteo de las perlas agregadas.
//            Métodos:
//    insertarPerla: Añade una perla al collar.
//            isComplete: Verifica si el collar ya tiene las 20 perlas necesarias.
//

//    NoMaterialsLeft: Es una excepción personalizada que se lanza cuando no hay más perlas de un color.


//    Empleado: Representa a un empleado que ensambla collares.
//            run: Es el método que ejecuta cada hilo.
//    Mientras haya materiales, el empleado ensambla collares.
//    Si se quedan sin materiales, termina el hilo mostrando un mensaje.
//    Método getCollaresFabricados: Devuelve cuántos collares fabricó este empleado.

//    main:
//    Crea el cesto y los empleados.
//    Lanza cada hilo (start).
//    Espera a que todos terminen (join).
//    Suma los collares fabricados por todos los empleados y muestra el total.

//    Ejemplo de salida
//
//
//    No hay más perlas BLANCAS
//    No hay más perlas AZULES
//    Número total de collares fabricados: 18
//
//
//    Esto significa que se fabricaron 18 collares antes de que se agotaran las perlas. ¡Cada hilo trabajó de forma concurrente!




}
