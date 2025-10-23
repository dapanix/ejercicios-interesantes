package ejsInicio.juego;
import java.sql.SQLOutput;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class principal {

    public static void celda(String habil,int anchura){
        System.out.println("*".repeat(anchura));
        System.out.print("*");
        System.out.print(" ".repeat(anchura-2));
        System.out.println("*");
        System.out.print("*");
        System.out.print(" ".repeat(anchura/2-5));
        System.out.print(habil);
        System.out.print(" ".repeat(anchura/2-5));
        System.out.println("*");
        System.out.print("*");
        System.out.print(" ".repeat(anchura-2));
        System.out.println("*");
        System.out.print("*".repeat(anchura));
        System.out.println();

    }









    public static void main(String[] args) throws InterruptedException {
        float vida1=100,golpe=0,escudo1=0,vida2=100,escudo2=0,golpe2=0,tiempo=0,tiempo1=0;
        boolean ataqEnemigo = false,defeEnemigo=false,vidaEnemigo=false;
        boolean parry=false;
        //comienzo
        System.out.println("########  ##     ## ######## ##        #######     ########  ########     ######     ###    ########     ###    ##       ##       ######## ########   #######   ######  ");
        System.out.println("##     ## ##     ## ##       ##       ##     ##    ##     ## ##          ##    ##   ## ##   ##     ##   ## ##   ##       ##       ##       ##     ## ##     ## ##    ## ");
        System.out.println("##     ## ##     ## ##       ##       ##     ##    ##     ## ##          ##        ##   ##  ##     ##  ##   ##  ##       ##       ##       ##     ## ##     ## ##       ");
        System.out.println("##     ## ##     ## ######   ##       ##     ##    ##     ## ######      ##       ##     ## ########  ##     ## ##       ##       ######   ########  ##     ##  ######  ");
        System.out.println("##     ## ##     ## ##       ##       ##     ##    ##     ## ##          ##       ######### ##     ## ######### ##       ##       ##       ##   ##   ##     ##       ## ");
        System.out.println("##     ## ##     ## ##       ##       ##     ##    ##     ## ##          ##    ## ##     ## ##     ## ##     ## ##       ##       ##       ##    ##  ##     ## ##    ## ");
        System.out.println("########   #######  ######## ########  #######     ########  ########     ######  ##     ## ########  ##     ## ######## ######## ######## ##     ##  #######   ######   ");
                System.out.println("juego por Daniel Fernandez");
                System.out.println("  ,   A           {}");
                System.out.println(" / \\, | ,        .--.");
                System.out.println("|    =|= >      /.--.\\");
                System.out.println(" \\ /` | `       |====|");
                System.out.println("  `   |         |`::`|");
                System.out.println("      |     .-;`\\..../`;-.");
                System.out.println("     /\\/  /  |...::...|  \\");
                System.out.println("     |:'\\ |   /'''::'''\\   |");
                System.out.println("      \\ /\\;-./\\   ::   /\\--;");
                System.out.println("      |\\ <` >  >._::_.<,<__>");
                System.out.println("      | `\"\"`  /   ^^   \\|  |");
                System.out.println("      |       |        |\\::/");
                System.out.println("      |       |        |/|||");
                System.out.println("      |       |___/\\___| '''");
                System.out.println("      |        \\_ || _/");
                System.out.println("      |        <_ >< _>");
                System.out.println("      |        |  ||  |");
                System.out.println("      |        |  ||  |");
                System.out.println("      |       _\\.:||:./_");
                System.out.println("      | jgs  /____/\\____\\");
            TimeUnit.SECONDS.sleep(2);

        System.out.println();
        celda("ataq = 1",20);
        celda("defe = 2",20);
        celda("vida = 3",20);
        System.out.println("para luchar, usa una de tus tres habilidades");
        System.out.println();
        while ((vida2>0) && (vida1>0)){
                Scanner sc = new Scanner(System.in);
                System.out.println("que habilidad deseas usar?: ");
                int habil = sc.nextInt();

                Random rand = new Random();
                int random = rand.nextInt(4);

                if (random == 1) {
                    ataqEnemigo = true;
                    defeEnemigo = false;
                    vidaEnemigo = false;
                }
                if (random == 2) {
                    ataqEnemigo = false;
                    defeEnemigo = true;
                    vidaEnemigo = false;
                }
                if (random == 3) {
                    ataqEnemigo = false;
                    defeEnemigo = false;
                    vidaEnemigo = true;
                }

            if (parry){
                System.out.println("En el turno anterior perdiste la espada");
                System.out.println("una pena, te toca esperar");
                Random r = new Random();
                int randomafterparry= r.nextInt(3);
                while (escudo2>0){
                    escudo2=escudo2-1;}
                parry=false;
                if (randomafterparry==1){
                    System.out.println("-El enemigo aprovechó que el parry para hacerte un ataque");
                    vida1=vida1-20;
                }
                    if (randomafterparry==2){
                    System.out.println("-el enemigo decide curarse");
                    vida2=vida2+20;
                }
                if (randomafterparry==0) {
                    System.out.println("-Has tenido suerte, el enemigo pasó el turno");
                }

            }
            else {
                if (escudo2>0) {
                    tiempo = tiempo + 1;
                    if (tiempo>2 && escudo2>1) {
                        while (escudo2>0){
                            escudo2=escudo2-1;}
                    }
                }
                if (escudo1>0) {
                    tiempo1 = tiempo1 + 1;
                    if (tiempo1>3 && escudo1>1) {
                        escudo1=0;
                    }
                }
                if (habil == 1) {
                    if (escudo2>0 && (defeEnemigo)) {
                        System.out.println("-El enemigo ha defendido tu ataque haciendote parry");
                        parry=true;
                    }
                    else {
                        if (ataqEnemigo) {
                            if (escudo1 > 0) {
                                System.out.println("          //| ___________________|`-._/\\_.-`|");
                                System.out.println("O|===|* >________________________|    ||    |");
                                System.out.println("          \\|                    |___o()o___|");
                                System.out.println("                                |__((<>))___|");
                                System.out.println("                                \\   o\\/o  /");
                                System.out.println("  -DEFENDISTE UN ATAQUE!!        \\   ||   /");
                                System.out.println("                                  \\  ||  /");
                                System.out.println("                                    '.||.'");
                                System.out.println();
                            }

                            Random an = new Random();
                            int a = an.nextInt(6);
                            Random ran = new Random();
                            int n = ran.nextInt(6);
                            System.out.println("  DUELO: LOS DOS HABEIS DECIDIDO ATACAR           ");
                            if (n == 1) {
                                System.out.println("-Fallo critico! No haces daño");
                            } else if (n == 5) {
                                golpe2 = 40;
                                System.out.println("-Critico! has hecho "+golpe2+"pts de daño");
                            }
                            if(n==2 || n==3 || n==4 ) {
                                golpe2 = 20;
                                System.out.println("-Has golpeado con "+golpe2+"pts de daño");
                            }
                            if (a > 3) {
                                golpe = 45;
                                System.out.println("-El enemigo ha acertado un critico!!");
                            } else {
                                golpe = 30;
                                System.out.println("-El enemigo ha inflingido "+golpe+" de daño");
                            }
                            vida1 = vida1 - golpe;
                            vida2 = vida2 - golpe2;
                            TimeUnit.SECONDS.sleep(1);
                            System.out.println("    __|=|__                         _ ");
                            System.out.println("   (_/`-`\\_)  OUCH te han hecho   /- |");
                            System.out.println("   //\\__//\\ daño de "+golpe+"       ___   \"");
                            System.out.println("   <>/   \\<>___________________|  /|--]");
                            System.out.println("    \\|_._|/                    | / |__|");
                            System.out.println("     <_I_>                       \\ /.\\ |");
                            System.out.println("      |||                          '|| ||");
                            System.out.println("     /_|_\\                        <_'<_'");
                            TimeUnit.SECONDS.sleep(5);


                        } else if (defeEnemigo) {
                            parry = true;
                            TimeUnit.SECONDS.sleep(1);
                            System.out.println("          //| ___________________|`-._/\\_.-`|");
                            System.out.println("O|===|* >________________________|    ||    |");
                            System.out.println("          \\|                    |___o()o___|");
                            System.out.println("                                |__((<>))___|");
                            System.out.println("                                \\   o\\/o  /");
                            System.out.println("  -EL ENEMIGO USO ESCUDO!!       \\   ||   /");
                            System.out.println("                                  \\  ||  /");
                            System.out.println("                                    '.||.'");
                            System.out.println();
                            System.out.println("tu espada no estara disponible el siguiente  turno");
                            TimeUnit.SECONDS.sleep(5);
                        } else if (vidaEnemigo) {
                            vida2 = vida2 - 40;
                            TimeUnit.SECONDS.sleep(1);
                            System.out.println("⠀⢀⡀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
                            System.out.println("⠀⠈⢿⣷⣦⣄⣀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀");
                            System.out.println("⠀⠀⠀⢻⣷⡙⠻⣿⣦⣄⣀⣀⣀⡀⠀⠀⠀⠀⠀⠀⣀⣤⠆⠀⠀⠀⠀⠀");
                            System.out.println("⠀⠀⠀⠀⢻⣿⣆⠈⠻⠟⢻⣿⣿⣁⣀⣀⣠⣤⣶⣿⠟⠁⠀⠀⠀⠀⠀⠀");
                            System.out.println("⠀⠀⠀⢀⣾⣿⣋⣤⣄⠀⠙⢿⣿⣿⡿⠿⣻⣿⡟⠁⠀⠀⠀⠀⠀⠀⠀⠀");
                            System.out.println("⠀⠀⠀⠛⠋⠉⠛⢻⣿⣧⠀⠀⠉⠁⠀⣴⣿⣿⠀⠀⠀⢀⣀⡄⠀⠀⠀⠀");
                            System.out.println("⠀⠀⠀⠀⠀⠀⠀⣸⣿⡿⠀⠀⠀⠀⠀⠸⣿⣿⣶⣶⣾⣿⠏⠀⠀⠀⠀⠀");
                            System.out.println("⠀⠀⠀⠀⠀⣠⣾⣿⣯⣶⣾⣿⣿⣦⡀⠀⠈⠛⠛⣽⣿⡏⠀⠀⢀⠀⠀⠀");
                            System.out.println("⠀⠀⠀⣠⠾⠟⠛⠉⠉⠀⠀⠀⢹⣿⣷⠀⠀⠀⠀⠻⣿⣧⣤⣴⡇⠀⠀⠀");
                            System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⣾⣿⣫⣴⣶⣤⡀⠀⠙⠿⠟⣿⡇⠀⠀⠀");
                            System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢀⣾⡿⠿⠿⠿⢿⣿⣿⣆⠀⠀⠸⣿⣷⡀⠀⠀");
                            System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠰⠋⠁⠀⠀⠀⠀⠀⠹⣿⣧⣶⣶⣤⡈⢿⣷⡀⠀");
                            System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⢰⠟⠛⠉⠉⠙⠻⣶⣽⣷⡀");
                            System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠙⠻⢷⡀");
                            System.out.println("⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠀⠁⠀");
                            System.out.println("CRITICO! has atacado cuando el enemigo se estaba sanando");
                            System.out.println("has hecho 40pts de daño!! herida critica al enemigo");
                            TimeUnit.SECONDS.sleep(5);
                        }
                        TimeUnit.SECONDS.sleep(1);
                    }
                }
                else if (habil == 2) {
                    escudo1=escudo1+1;
                    if (ataqEnemigo){
                            System.out.println("          //| ___________________|`-._/\\_.-`|");
                            System.out.println("O|===|* >________________________|    ||    |");
                            System.out.println("          \\|                    |___o()o___|");
                            System.out.println("                                |__((<>))___|");
                            System.out.println("                                \\   o\\/o  /");
                            System.out.println("  -DEFENDISTE UN ATAQUE!!        \\   ||   /");
                            System.out.println("                                  \\  ||  /");
                            System.out.println("                                    '.||.'");
                            TimeUnit.SECONDS.sleep(5);
                            celda("ataq = 1", 20);
                            celda("defe = 2", 20);
                            celda("vida = 3", 20);
                            System.out.println("-Enhorabuena! has hecho parry a un ataque enemigo,");
                            TimeUnit.SECONDS.sleep(2);
                            Random ra = new Random();
                            System.out.println("El enemigo pierde el siguiente movimiento...");
                            System.out.println();
                            System.out.println();
                            Scanner s = new Scanner(System.in);
                            System.out.println("que habilidad deseas usar, despues de haber defendido?: ");
                            int habilparry = s.nextInt();
                            if (habilparry == 1) {
                                Random hola = new Random();
                                int xd = hola.nextInt(6);

                                if (xd == 1) {
                                    golpe = 0;
                                    System.out.println("-Fallo critico! No haces daño");
                                } else if (xd == 5) {
                                    golpe = 40;
                                    System.out.println("-Critico! has hecho 40pts de daño");
                                }
                                if (xd > 1 && xd < 5) {
                                    golpe = 20;
                                    System.out.println("-Has golpeado con 20pts de daño");
                                }
                            }
                            if (habilparry == 2) {
                                escudo1 = escudo1 + 1;
                            }
                            if (habilparry == 3) {
                                System.out.println("-te has curado 20pts");
                                vida1 = vida1 + 20;
                            }

                    }
                    if (defeEnemigo){

                        escudo2=escudo2+1;
                        System.out.println("          {}                          {}");
                        System.out.println("         .--.                         .--.");
                        System.out.println("        /.--.\\                       /.--.\\");
                        System.out.println("        |====|                       |====|");
                        System.out.println("        |`::`|                       |`::`|");
                        System.out.println("    .-;`\\..../`;_.-^-._         .-;`\\..../`;_.-^-._");
                        System.out.println("   /  |...::..|`   :   `|       /  |...::..|`   :   `|");
                        System.out.println("  |   /'''::''|   .:.   |      |   /'''::''|   .:.   |");
                        System.out.println("  ;--'\\   ::  |..:::::..|      ;--'\\   ::  |..:::::..|");
                        System.out.println("  <__> >._::_.| ':::::' |      <__> >._::_.| ':::::' |");
                        System.out.println("  |  |/   ^^  |   ':'   |      |  |/   ^^  |   ':'   |");
                        System.out.println("  \\::/|       \\    :    /      \\::/|       \\    :    /");
                        System.out.println("  |||\\|        \\   :   /       |||\\|        \\   :   /");
                        System.out.println("  ''' |___/\\___|`-.:.-`         ''' |___/\\___|`-.:.-`");
                        System.out.println("       \\_ || _/                        \\_ || _/");
                        System.out.println("       <_ >< _>                        <_ >< _>");
                        System.out.println("       |  ||  |                        |  ||  |");
                        System.out.println("       |  ||  |                        |  ||  |");
                        System.out.println("      _\\.:||:./_                     _\\.:||:./_");
                        System.out.println("jgs  /____/\\____\\                jgs  /____/\\____\\");
                        System.out.println("-ambos habeis decidido usar escudo");
                    }
                    if (vidaEnemigo){
                        System.out.println("  /==========================\\");
                        System.out.println(" / : : : : : |::::| : : : : : \\");
                        System.out.println("{ : : : : : :|::::|: : : : : : }");
                        System.out.println(" \\ : : : : : |::::| : : : : : /");
                        System.out.println("  \\==========================/");
                        System.out.println("-El enemigo se ha curado mientras usabas el escudo");
                        vida2=vida2+10;
                    }
                    TimeUnit.SECONDS.sleep(1);
                }
                else if (habil==3){
                    if (ataqEnemigo){
                        if (escudo1>0){
                            System.out.println("-Tu escudo bloqueo el ataque enemigo");
                            escudo1=escudo1-1;
                            System.out.println("te curaste 20pts");
                            vida1=vida1+20;
                        }
                        else {
                            System.out.println("  TE HAN ACERTADO UN ATAQUE CRITICO          ");
                            System.out.println("    __|=|__                         _ ");
                            System.out.println("   (_/`-`\\_)  OUCH te han hecho   /- |");
                            System.out.println("   //\\__//\\ 40pts de daño      ___   \"");
                            System.out.println("   <>/   \\<>___________________|  /|--]");
                            System.out.println("    \\|_._|/                    | / |__|");
                            System.out.println("     <_I_>                       \\ /.\\ |");
                            System.out.println("      |||                          '|| ||");
                            System.out.println("     /_|_\\                        <_'<_'");
                            System.out.println("-critico! ell enemigo ha atacado mientras intentabas curarte");
                            vida1 = vida1 - 40;
                        }
                    }
                    if (defeEnemigo){
                        System.out.println("  /==========================\\");
                        System.out.println(" / : : : : : |::::| : : : : : \\");
                        System.out.println("{ : : : : : :|::::|: : : : : : }");
                        System.out.println(" \\ : : : : : |::::| : : : : : /");
                        System.out.println("  \\==========================/");
                        System.out.println("-el enemigo decidio defenderse, has curado 10 pts de vida");
                        vida1=vida1+10;
                        escudo2=escudo2+1;
                    }
                    if (vidaEnemigo){
                        System.out.println("  /==========================\\");
                        System.out.println(" / : : : : : |::::| : : : : : \\");
                        System.out.println("{ : : : : : :|::::|: : : : : : }");
                        System.out.println(" \\ : : : : : |::::| : : : : : /");
                        System.out.println("  \\==========================/");
                        System.out.println("-el enemigo tambien decidio curarse, los dos sumais 10 pts de vida");
                        vida1=vida1+10;
                        vida2=vida2+10;
                    }
                    TimeUnit.SECONDS.sleep(1);
                }

            }
            System.out.println();
            System.out.println();
            System.out.println("Tus estadisticas:");
            celda("defe ="+escudo1,20);
            celda("vida ="+vida1,20);
            System.out.println("Estadisticas de el enemigo:");
            TimeUnit.SECONDS.sleep(1);
            celda("defe ="+escudo2,20);
            celda("vida ="+vida2,20);





        }
        if (vida1<0){
            System.out.println("Parguela, perdistes contra un programa marronero de java");
            System.out.println("FIN");
        }
        if (vida2<0){
            System.out.println("Enhorabuena, matastes al enemigo");
            System.out.println("FIN");
        }

    }
}


