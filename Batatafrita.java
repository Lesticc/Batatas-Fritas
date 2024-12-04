import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class Batatafrita{
    public static Scanner scanner = new Scanner(System.in);
    public static Vars vars = new Vars();
    public static Data data = new Data();

    public static void main(String[] args){
        if(vars.JVM_batatainfinita==true||vars.JVM_dinheiroinfinito==true||vars.JVM_cheats==true){
            vars.cheat = true;
        }
        menu();
    }

    public static void menu(){
        try {
            System.out.print(vars.JVM_debug ? "\nDEBUG: A função menu() foi rodada.\n" : "");
            System.out.print(vars.elemento_barra + vars.n + vars.console + vars.n + vars.elemento_barra + vars.n);
            String escolha = scanner.nextLine();
            switch(escolha){
                case "0" -> {
                    sair();
                }
    
                case "1" -> {
                    System.out.println(vars.entrando);
                    menuGame();                
                }

                case "2" -> {
                    System.out.println(vars.abrindo_console);
                    console();
                }

                case "3" -> {
                    System.out.println(vars.elemento_barra + vars.n + vars.introducao_3 + vars.n + vars.elemento_barra);
                    conquistas();
                }
    
                default -> {
                    System.out.println(vars.indisponivel);
                    menu();
                }
            }
        }catch(Exception e){
            System.out.println(vars.erro + vars.n + e);
        }
    }

    public static void menuGame(){
        System.out.print(vars.JVM_debug ? "\nDEBUG: A função menuGame() foi rodada.\n" : "");
        System.out.print(vars.elemento_barra + vars.n + vars.escolher_modo + vars.n + vars.elemento_barra + vars.n);
        String escolha = scanner.nextLine();
        switch(escolha){
            case "0" -> {
                System.out.println(vars.abrindo_console);
                console();
            }

            case "1" -> {
                System.out.println(vars.elemento_barra + vars.n + vars.introducao_0 + vars.introducao_2);
                fazer();
            }

            case "2" -> {
                System.out.println(vars.elemento_barra + vars.n + vars.introducao_1 + vars.money + vars.introducao_2);
                pedir();
            }

            default -> {
                System.out.println(vars.indisponivel);
                menu();
            }
        }
    }

    @SuppressWarnings({"UseSpecificCatch", "ConvertToStringSwitch"})
    public static void fazer(){
        System.out.print(vars.JVM_debug ? "\nDEBUG: A função fazer() foi rodada.\n" : "");
        do { 
            try {
               String input = scanner.nextLine();
                if(input.equals("0")){ // Usando if, pois se fosse switch, o break não quebraria o 'do'.
                    break;
                }else if(input.equals("1")){
                    fazer0();
                }else{
                    System.out.println(vars.indisponivel + vars.n);
                }
            } catch (Exception e) {
                System.out.println(vars.erro + vars.n + e);
            }
        } while (true);
        menu();
    }
    
    @SuppressWarnings({"UseSpecificCatch", "ConvertToStringSwitch"})
    public static void pedir(){
        System.out.print(vars.JVM_debug ? "\nDEBUG: A função pedir() foi rodada.\n" : "");
        do { 
            try {
               String input = scanner.nextLine();
                if(input.equals("0")){ // Usando if, pois se fosse switch, o break não quebraria o 'do'.
                    break;
                }else if(input.equals("1")){
                    if(vars.JVM_dinheiroinfinito==true&&vars.JVM_batatainfinita==true){
                        pedir0();
                    }else if(vars.money>=3&&vars.JVM_batatainfinita==true){
                        pedir0();
                    }else if(vars.money>=3&&vars.batatas>0){
                        pedir0();
                    }else if(vars.money<3){
                        System.out.println(vars.return2(vars.money));
                    }else{
                        System.out.println(vars.sem_batatas + vars.n);
                    }
                }else{
                    System.out.println(vars.indisponivel + vars.n);
                }
            } catch (Exception e) {
                System.out.println(vars.erro + vars.n + e);
            }
        } while (true);
        menu();
    }

    public static void conquistas(){
        System.out.print(vars.JVM_debug ? "\nDEBUG: A função conquistas() foi rodada.\n" : "");
        System.out.println(vars.return4(vars.conq_elem_01, vars.conq_elem_02, vars.conq_elem_03, vars.conq_elem_04, vars.conq_elem_05, vars.conq_elem_06, vars.conq_elem_07, vars.conq_elem_08, vars.conq_elem_09, vars.JVM_lang));
        System.out.println(vars.elemento_barra);
        do { 
            try {
                String input = scanner.nextLine();
                if(input.equals("0")){
                    break;
                }else{
                    System.out.println(vars.indisponivel);
                }
            } catch (Exception e) {
                System.out.println(vars.erro + vars.n + e);
            }
        } while (true);
        menu(); // usa a camera do obs
    }

    @SuppressWarnings("UseSpecificCatch")
    public static void console(){
        System.out.print(vars.JVM_debug ? "\nDEBUG: A função console() foi rodada.\n" : "");
        System.out.println(vars.elemento_barra + vars.n + vars.dica_console);
        int output = 0;
        int rage = 0;
        do{ 
            try{
                System.out.print("- ");
                String input = scanner.nextLine();
                System.out.print(vars.n);
                if(input.equals("help")){
                    System.out.println(vars.help_console);
                }else if(input.contains("break")){
                    break;
                }else if(input.contains("language")){
                    System.out.println(vars.language);
                }else if(input.contains("vars")){
                    System.out.println("jvm_cheats " + vars.JVM_cheats + "(" + vars.JVM_cheats_int + ")" + (vars.JVM_cheats ? "      " : "     ") + "jvm_debug " + vars.JVM_debug + "(" + vars.JVM_debug_int + ")\njvm_lang   " + vars.JVM_lang + "(" + vars.JVM_lang_int + ")");
                }else if(input.contains("save")){
                    save();
                }else if(input.contains("load")){
                    load();
                }else if(input.contains("jvm_cheats")){
                    vars.cheat = true;
                    int falso = input.lastIndexOf("0");
                    int verdadeiro = input.lastIndexOf("1");
                    if(falso==11){
                        System.out.println(vars.variavel_false);
                        vars.JVM_cheats = false;
                        vars.JVM_cheats_int = 0;
                    }else if(verdadeiro==11){
                        System.out.println(vars.variavel_true);
                        vars.JVM_cheats = true;
                        vars.JVM_cheats_int = 1;
                        vars.cheat = true;
                    }else{
                        System.out.println("A varíavel JVM_cheats tem o valor de " + vars.JVM_cheats + "(" + vars.JVM_cheats_int + ")");
                    }
                    if(vars.JVM_debug==true){
                        System.out.println("DEBUG: A int falso é " + falso);
                        System.out.println("DEBUG: A int verdadeiro é " + verdadeiro);
                        System.out.println("DEBUG: A varíavel JVM_cheats foi modificada para " + vars.JVM_cheats + "(" +  vars.JVM_cheats_int + ")");
                    }
                }else if(input.contains("jvm_debug")){
                    int falso = input.lastIndexOf("0");
                    int verdadeiro = input.lastIndexOf("1");
                    Boolean procedencia = vars.JVM_debug;
                    if(falso==10){
                        System.out.println(vars.variavel_false);
                        vars.JVM_debug = false;
                        vars.JVM_debug_int = 0;
                    }else if(verdadeiro==10){
                        System.out.println(vars.variavel_true);
                        vars.JVM_debug = true;
                        vars.JVM_debug_int = 1;
                    }else{
                        System.out.println("A varíavel JVM_debug tem o valor de " + vars.JVM_debug + "(" + vars.JVM_debug_int + ")");
                    }
                    if(procedencia==true){
                        System.out.println("DEBUG: A int falso é " + falso);
                        System.out.println("DEBUG: A int verdadeiro é " + verdadeiro);
                        System.out.println("DEBUG: A varíavel JVM_debug foi modificada para " + vars.JVM_debug + "(" +  vars.JVM_debug_int + ")");
                    }
                }else if(input.contains("jvm_lang")){
                    int falso = input.lastIndexOf("0");
                    int verdadeiro = input.lastIndexOf("1");
                    Boolean procedencia = vars.JVM_debug;
                    if(falso==9){
                        if(vars.JVM_lang==true){
                            traduzir_usbr();
                        }
                        System.out.println(vars.variavel_false);
                        vars.JVM_lang = false;
                        vars.JVM_lang_int = 0;
                    }else if(verdadeiro==9){
                        if(vars.JVM_lang==false){
                            traduzir_brus();
                        }
                        System.out.println(vars.variavel_true);
                        vars.JVM_lang = true;
                        vars.JVM_lang_int = 1;
                    }else{
                        System.out.println("A varíavel JVM_lang tem o valor de " + vars.JVM_lang + "(" + vars.JVM_lang_int + ")");
                    }
                    if(procedencia==true){
                        System.out.println("DEBUG: A int falso é " + falso);
                        System.out.println("DEBUG: A int verdadeiro é " + verdadeiro);
                        System.out.println("DEBUG: A varíavel JVM_lang foi modificada para " + vars.JVM_lang + "(" +  vars.JVM_lang_int + ")");
                    }
                }else if(input.contains("jvm_infinitepotato")){
                    int falso = input.lastIndexOf("0");
                    int verdadeiro = input.lastIndexOf("1");
                    if(falso==19){
                        System.out.println(vars.variavel_false);
                        vars.JVM_batatainfinita = false;
                        vars.JVM_batatainfinita_int = 0;
                    }else if(verdadeiro==19){
                        System.out.println(vars.variavel_true);
                        vars.cheat = true;
                        vars.JVM_batatainfinita = true;
                        vars.JVM_batatainfinita_int = 1;
                    }else{
                        System.out.println("A varíavel JVM_debug tem o valor de " + vars.JVM_batatainfinita + "(" + vars.JVM_batatainfinita_int + ")");
                    }
                    if(vars.JVM_debug==true){
                        System.out.println("DEBUG: A int falso é " + falso);
                        System.out.println("DEBUG: A int verdadeiro é " + verdadeiro);
                        System.out.println("DEBUG: A varíavel JVM_batatainfinita foi modificada para " + vars.JVM_batatainfinita + "(" +  vars.JVM_batatainfinita_int + ")");
                    }
                }else if(input.contains("jvm_infinitemoney")){
                    int falso = input.lastIndexOf("0");
                    int verdadeiro = input.lastIndexOf("1");
                    if(falso==18){
                        System.out.println(vars.variavel_false);
                        vars.JVM_dinheiroinfinito = false;
                        vars.JVM_dinheiroinfinito_int = 0;
                    }else if(verdadeiro==18){
                        System.out.println(vars.variavel_true);
                        vars.cheat = true;
                        vars.JVM_dinheiroinfinito = true;
                        vars.JVM_dinheiroinfinito_int = 1;
                    }else{
                        System.out.println("A varíavel JVM_debug tem o valor de " + vars.JVM_dinheiroinfinito + "(" + vars.JVM_dinheiroinfinito_int + ")");
                    }
                    if(vars.JVM_debug==true){
                        System.out.println("DEBUG: A int falso é " + falso);
                        System.out.println("DEBUG: A int verdadeiro é " + verdadeiro);
                        System.out.println("DEBUG: A varíavel JVM_batatainfinita foi modificada para " + vars.JVM_dinheiroinfinito + "(" +  vars.JVM_dinheiroinfinito_int + ")");
                    }
                }else if(input.contains("var_money")){
                    if(vars.JVM_cheats==true){
                        output = 1;
                        System.out.println(vars.newvalue);
                    }else{
                        System.out.println(vars.require_jvmcheats);
                    }
                }else if(input.contains("var_batatas")){
                    if(vars.JVM_cheats==true){
                        output = 2;
                        System.out.println(vars.newvalue);
                    }else{
                        System.out.println(vars.require_jvmcheats);
                    }
                }else if(input.contains("var_batatasperwork")){
                    if(vars.JVM_cheats==true){
                        output = 3;
                        System.out.println(vars.newvalue);
                    }else{
                        System.out.println(vars.require_jvmcheats);
                    }
                }else if(input.contains("var_dinheiroperwork")){
                    if(vars.JVM_cheats==true){
                        output = 4;
                        System.out.println(vars.newvalue);
                    }else{
                        System.out.println(vars.require_jvmcheats);
                    }
                }else if(input.contains("var_pricepotato")){
                    if(vars.JVM_cheats==true){
                        output = 5;
                        System.out.println(vars.newvalue);
                    }else{
                        System.out.println(vars.require_jvmcheats);
                    }
                }else if(output==1){
                    vars.money = Integer.parseInt(input);
                    System.out.println(vars.return0("var_money", vars.money));
                    output = 0;
                }else if(output==2){
                    vars.batatas = Integer.parseInt(input);
                    System.out.println(vars.return0("var_batatas", vars.batatas));
                    output = 0;
                }else if(output==3){
                    vars.batatasportrabalho = Integer.parseInt(input);
                    System.out.println(vars.return0("var_batatasportrabalho", vars.batatasportrabalho));
                    output = 0;
                }else if(output==4){
                    vars.dinheiroportrabalho = Integer.parseInt(input);
                    System.out.println(vars.return0("var_dinheiroportrabalho", vars.dinheiroportrabalho));
                    output = 0;
                }else if(output==5){
                    vars.valorbatata = Integer.parseInt(input);
                    System.out.println(vars.return0("var_valorbatata", vars.valorbatata));
                    output = 0;
                }else{
                    rage++;
                    if(rage==10){
                        System.out.println(vars.help_console);
                    }else{
                        System.out.println(vars.indisponivel);
                    }
                }
                System.out.print(vars.n);
            }catch (Exception e){
                System.out.println(vars.erro + vars.n + e);
            }
        }while(true);

        menu();
    }

    @SuppressWarnings("UseSpecificCatch")
    public static void pedir0(){
        try {
            System.out.print(vars.batatapedindo);
            Thread.sleep(1000);
            System.out.print("\b \b");
            Thread.sleep(1000);
            System.out.print("\b \b");
            Thread.sleep(0050);
            for (int i = 0; i < 15; i++) {
                System.out.print("\b");
            }
            vars.batatas --;
            vars.batataspedidas ++;
            vars.money -= vars.valorbatata;
            vars.dinheirogasto += vars.valorbatata;
            System.out.print(vars.return1(vars.money));
            switch (vars.batataspedidas) { // te odeio interpretador
                case 10 -> {
                    vars.conq_elem_04 = true;
                    System.out.println(vars.conquista + vars.conq_titl_04 + vars.n);
                }
                case 100 -> {
                    vars.conq_elem_05 = true;
                    System.out.println(vars.conquista + vars.conq_titl_05 + vars.n);
                }
                case 1000 -> {
                    vars.conq_elem_06 = true;
                    System.out.println(vars.conquista + vars.conq_titl_06 + vars.n);
                }
            }
        } catch (Exception e) {
            System.out.println(vars.erro + vars.n + e);
        }
    }

    @SuppressWarnings("UseSpecificCatch")
    public static void fazer0(){
        try {
            System.out.print(vars.batatafazendo);
            Thread.sleep(1000); // poxa interpretador, pq :( java as vezes bate, e com força ;-;
            System.out.print("\b \b");
            Thread.sleep(1000);
            System.out.print("\b \b");
            Thread.sleep(1000);
            System.out.print("\b \b");
            Thread.sleep(0050);
            for (int i = 0; i < 15; i++) {
                System.out.print("\b");
            }
            vars.batatas += vars.batatasportrabalho;
            vars.batatasfeitas += vars.batatasportrabalho;
            vars.money += vars.dinheiroportrabalho;
            vars.dinheirofeito += vars.dinheiroportrabalho;
            System.out.print(vars.batatapronta + vars.return3(vars.money, true) + "\n\n");
            if(vars.batatasfeitas == 10){
                vars.conq_elem_01 = true;
                System.out.println(vars.conquista + vars.conq_titl_01 + vars.n);
            }else if(vars.batatasfeitas == 100){
                vars.conq_elem_02 = true;
                System.out.println(vars.conquista + vars.conq_titl_02 + vars.n);
            }else if(vars.batatasfeitas == 1000){
                vars.conq_elem_03 = true;
                System.out.println(vars.conquista + vars.conq_titl_03 + vars.n);
            }else if(vars.money==10){
                vars.conq_elem_07 = true;
                System.out.println(vars.conquista + vars.conq_titl_07 + vars.n);
            }else if(vars.money == 100){
                vars.conq_elem_08 = true;
                System.out.println(vars.conquista + vars.conq_titl_08 + vars.n);
            }else if(vars.money == 1000){
                vars.conq_elem_09 = true;
                System.out.println(vars.conquista + vars.conq_titl_09 + vars.n);
            }  
        } catch (Exception e) {
            System.out.println(vars.erro + vars.n + e);
        }
    }

    @SuppressWarnings("static-access")
    public static void save(){
        data.save(vars.money, vars.batatas, vars.batatasportrabalho, vars.dinheiroportrabalho, vars.valorbatata, vars.JVM_cheats, vars.JVM_debug, vars.JVM_lang, vars.JVM_batatainfinita, vars.JVM_dinheiroinfinito, vars.JVM_cheats_int, vars.JVM_debug_int, vars.JVM_lang_int, vars.JVM_batatainfinita_int, vars.JVM_dinheiroinfinito_int, vars.cheat, vars.batatasfeitas, vars.batataspedidas, vars.dinheirofeito, vars.dinheirogasto, vars.conq_elem_01, vars.conq_elem_02, vars.conq_elem_03, vars.conq_elem_04, vars.conq_elem_05, vars.conq_elem_06, vars.conq_elem_07, vars.conq_elem_08, vars.conq_elem_09);
    }

    public static void load(){
        try (BufferedReader reader = new BufferedReader(new FileReader("Save.txt"))){
            String line;
            
            while ((line = reader.readLine()) != null){
                // Verifica se a linha é a que deve ser ignorada
                if(line.trim().equals("Feito por Lestic ---- (NAO EDITE ESSA LINHA)")){
                    continue;  // Ignora esta linha e passa para a próxima
                }

                // Divide a linha na chave e no valor pelo sinal de igual
                String[] parts = line.split("=");

                // Verifica se a linha está no formato chave=valor
                if (parts.length == 2) {
                    String key = parts[0].trim();   // A chave (antes do '=')
                    String value = parts[1].trim(); // O valor (depois do '=')

                    switch (key) { // te odeio interpretador 3
                        case "money" -> vars.money = Integer.parseInt(value);

                        case "batatas" -> vars.batatas = Integer.parseInt(value);

                        case "batatasportrabalho" -> vars.batatasportrabalho = Integer.parseInt(value);

                        case "dinheiroportrabalho" -> vars.dinheiroportrabalho = Integer.parseInt(value);

                        case "valorbatata" -> vars.valorbatata = Integer.parseInt(value);

                        case "JVM_cheats" -> vars.JVM_cheats = Boolean.valueOf(value);

                        case "JVM_debug" -> vars.JVM_debug = Boolean.valueOf(value);

                        case "JVM_lang" -> vars.JVM_lang = Boolean.valueOf(value);

                        case "JVM_batatainfinita" -> vars.JVM_batatainfinita = Boolean.valueOf(value);

                        case "JVM_dinheiroinfinito" -> vars.JVM_dinheiroinfinito = Boolean.valueOf(value);

                        case "JVM_cheats_int" -> vars.JVM_cheats_int = Integer.parseInt(value);

                        case "JVM_debug_int" -> vars.JVM_debug_int = Integer.parseInt(value);

                        case "JVM_lang_int" -> vars.JVM_lang_int = Integer.parseInt(value);

                        case "JVM_batatainfinita_int" -> vars.JVM_batatainfinita_int = Integer.parseInt(value);

                        case "JVM_dinheiroinfinito_int" -> vars.JVM_dinheiroinfinito_int = Integer.parseInt(value);

                        case "cheat" -> vars.cheat = Boolean.valueOf(value);

                        case "batatasfeitas" -> vars.batatasfeitas = Integer.parseInt(value);

                        case "batataspedidas" -> vars.batataspedidas = Integer.parseInt(value);

                        case "dinheirofeito" -> vars.dinheirofeito = Integer.parseInt(value);

                        case "dinheirogasto" -> vars.dinheirogasto = Integer.parseInt(value);

                        case "conq_elem_01" -> vars.conq_elem_01 = Boolean.valueOf(value);

                        case "conq_elem_02" -> vars.conq_elem_02 = Boolean.valueOf(value);

                        case "conq_elem_03" -> vars.conq_elem_03 = Boolean.valueOf(value);

                        case "conq_elem_04" -> vars.conq_elem_04 = Boolean.valueOf(value);

                        case "conq_elem_05" -> vars.conq_elem_05 = Boolean.valueOf(value);

                        case "conq_elem_06" -> vars.conq_elem_06 = Boolean.valueOf(value);

                        case "conq_elem_07" -> vars.conq_elem_07 = Boolean.valueOf(value);

                        case "conq_elem_08" -> vars.conq_elem_08 = Boolean.valueOf(value);

                        case "conq_elem_09" -> vars.conq_elem_09 = Boolean.valueOf(value);
                    }
                }
            }
            System.out.println(vars.carregado);
        } catch (IOException e) {
            System.out.println(vars.erro + vars.n + e);
        }
    }

    public static void traduzir_brus(){
        vars.abrindo_console = vars.abrindo_console_us;
        vars.variavel_true = vars.variavel_true_us;
        vars.variavel_false = vars.variavel_false_us;
        vars.dica_console = vars.dica_console_us;
        vars.help_console = vars.help_console_us;
        vars.require_jvmcheats = vars.require_jvmcheats_us;
        vars.newvalue = vars.newvalue_us;
        vars.language = vars.language_us;
        vars.stats = vars.stats_us;
        
        vars.entrando = vars.entrando_us;
        vars.saindo = vars.saindo_us;
        vars.console = vars.console_us;
        vars.escolher_modo = vars.escolher_modo_us;
        vars.erro = vars.erro_us;
        vars.indisponivel = vars.indisponivel_us;
        vars.introducao_0 = vars.introducao_0_us;
        vars.introducao_1 = vars.introducao_1_us;
        vars.introducao_2 = vars.introducao_2_us;
        vars.introducao_3 = vars.introducao_3_us;
        vars.batatapronta = vars.batatapronta_us;
        vars.batatapedindo = vars.batatapedindo_us;
        vars.batatafazendo = vars.batatafazendo_us;
        vars.batatapedida = vars.batatapedida_us;
        vars.sem_batatas = vars.sem_batatas_us;

        vars.conq_titl_01 = vars.conq_titl_01_us;
        vars.conq_titl_02 = vars.conq_titl_02_us;
        vars.conq_titl_03 = vars.conq_titl_03_us;
        vars.conq_titl_04 = vars.conq_titl_04_us;
        vars.conq_titl_05 = vars.conq_titl_05_us;
        vars.conq_titl_06 = vars.conq_titl_06_us;
        vars.conq_titl_07 = vars.conq_titl_07_us;
        vars.conq_titl_08 = vars.conq_titl_08_us;
        vars.conq_titl_09 = vars.conq_titl_09_us;
        
        vars.return00 = vars.return00_us;
        vars.return01 = vars.return01_us;
        vars.return10 = vars.return10_us;
        vars.return20 = vars.return20_us;
        vars.return21 = vars.return21_us;
        vars.return22 = vars.return22_us;
        vars.return23 = vars.return23_us;
        vars.return30 = vars.return30_us;       
        
        vars.stats01 = vars.stats01_us;
        vars.stats02 = vars.stats02_us;
        vars.stats03 = vars.stats03_us;
        vars.stats04 = vars.stats04_us;

        vars.conquista = vars.conquista_us;

        vars.carregado = vars.carregado_us;
        vars.salvado = vars.salvado_us;
    }

    public static void traduzir_usbr(){
        vars.abrindo_console = vars.abrindo_console_br;
        vars.variavel_true = vars.variavel_true_br;
        vars.variavel_false = vars.variavel_false_br;
        vars.dica_console = vars.dica_console_br;
        vars.help_console = vars.help_console_br;
        vars.require_jvmcheats = vars.require_jvmcheats_br;
        vars.newvalue = vars.newvalue_br;
        vars.language = vars.language_br;
        vars.stats = vars.stats_br;
        
        vars.entrando = vars.entrando_br;
        vars.saindo = vars.saindo_br;
        vars.console = vars.console_br;
        vars.escolher_modo = vars.escolher_modo_br;
        vars.erro = vars.erro_br;
        vars.indisponivel = vars.indisponivel_br;
        vars.introducao_0 = vars.introducao_0_br;
        vars.introducao_1 = vars.introducao_1_br;
        vars.introducao_2 = vars.introducao_2_br;
        vars.introducao_3 = vars.introducao_3_br;
        vars.batatapronta = vars.batatapronta_br;
        vars.batatapedindo = vars.batatapedindo_br;
        vars.batatafazendo = vars.batatafazendo_br;
        vars.batatapedida = vars.batatapedida_br;
        vars.sem_batatas = vars.sem_batatas_br;

        vars.conq_titl_01 = vars.conq_titl_01_br;
        vars.conq_titl_02 = vars.conq_titl_02_br;
        vars.conq_titl_03 = vars.conq_titl_03_br;
        vars.conq_titl_04 = vars.conq_titl_04_br;
        vars.conq_titl_05 = vars.conq_titl_05_br;
        vars.conq_titl_06 = vars.conq_titl_06_br;
        vars.conq_titl_07 = vars.conq_titl_07_br;
        vars.conq_titl_08 = vars.conq_titl_08_br;
        vars.conq_titl_09 = vars.conq_titl_09_br;
        
        vars.return00 = vars.return00_br;
        vars.return01 = vars.return01_br;
        vars.return10 = vars.return10_br;
        vars.return20 = vars.return20_br;
        vars.return21 = vars.return21_br;
        vars.return22 = vars.return22_br;
        vars.return23 = vars.return23_br;
        vars.return30 = vars.return30_br;

        vars.stats01 = vars.stats01_br;
        vars.stats02 = vars.stats02_br;
        vars.stats03 = vars.stats03_br;
        vars.stats04 = vars.stats04_br;

        vars.conquista = vars.conquista_br;

        vars.carregado = vars.carregado_br;
        vars.salvado = vars.salvado_br;
    }

    public static void sair(){
        try {
            String a = ": ";
            String g = "          ";
            String n = vars.n;
            System.out.print(vars.JVM_debug ? "\nDEBUG: A função sair() foi rodada.\n" : "");
            System.out.println(vars.elemento_barra + n + vars.stats + n + vars.elemento_barra2 + n + n + vars.stats01 + a + vars.batatasfeitas + g + vars.stats02 + a + vars.batataspedidas + n + vars.stats03 + a + vars.dinheirofeito + g + vars.stats04 + a +vars.dinheirogasto + "\n\nCheat: " + (vars.cheat ? vars.verdadeiro : vars.falso) + n + vars.elemento_barra);
            System.out.println(vars.saindo_br);
        } catch (Exception e) {
            System.out.println(vars.erro + vars.n + e);
        }
    }
}