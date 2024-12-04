import java.io.BufferedWriter;
import java.io.FileWriter;    
import java.io.IOException; 

public class Data {
    public static Vars vars = new Vars();

    public static void save(int var01, int var02, int var03, int var04, int var05, Boolean var06, Boolean var07, Boolean var08, Boolean var09, Boolean var10, int var11, int var12, int var13, int var14, int var15, Boolean var16, int var17, int var18, int var19, int var20, Boolean var21, Boolean var22, Boolean var23, Boolean var24, Boolean var25, Boolean var26, Boolean var27, Boolean var28, Boolean var29){
        try (BufferedWriter writer = new BufferedWriter(new FileWriter("Save.txt"))) {
            writer.write("money= " + var01);
            writer.newLine();
            writer.write("batatas= " + var02);
            writer.newLine();
            writer.write("batatasportrabalho= " + var03);
            writer.newLine();
            writer.write("dinheiroportrabalho= " + var04);
            writer.newLine();
            writer.write("valorbatata= " + var05);
            writer.newLine();
            writer.write("JVM_cheats= " + var06);
            writer.newLine();
            writer.write("JVM_debug= " + var07);
            writer.newLine();
            writer.write("JVM_lang= " + var08);
            writer.newLine();
            writer.write("JVM_batatainfinita= " + var09);
            writer.newLine();
            writer.write("JVM_dinheiroinfinito= " + var10);
            writer.newLine();
            writer.write("JVM_cheats_int= " + var11);
            writer.newLine();
            writer.write("JVM_debug_int= " + var12);
            writer.newLine();
            writer.write("JVM_lang_int= " + var13);
            writer.newLine();
            writer.write("JVM_batatainfinita_int= " + var14);
            writer.newLine();
            writer.write("JVM_dinheiroinfinito_int= " + var15);
            writer.newLine();
            writer.write("cheat= " + var16);
            writer.newLine();
            writer.write("batatasfeitas= " + var17);
            writer.newLine();
            writer.write("batataspedidas= " + var18);
            writer.newLine();
            writer.write("dinheirofeito= " + var19);
            writer.newLine();
            writer.write("dinheirogasto= " + var20);
            writer.newLine();
            writer.write("conq_elem_01= " + var21);
            writer.newLine();
            writer.write("conq_elem_02= " + var22);
            writer.newLine();
            writer.write("conq_elem_03= " + var23);
            writer.newLine();
            writer.write("conq_elem_04= " + var24);
            writer.newLine();
            writer.write("conq_elem_05= " + var25);
            writer.newLine();
            writer.write("conq_elem_06= " + var26);
            writer.newLine();
            writer.write("conq_elem_07= " + var27);
            writer.newLine();
            writer.write("conq_elem_08= " + var28);
            writer.newLine();
            writer.write("conq_elem_09= " + var29);
            writer.newLine();
            writer.newLine();
            writer.write("Feito por Lestic ---- (NAO EDITE ESSA LINHA)"); // se editar vai quebrar, de proposito
            System.out.println(var08 ? vars.salvado_us : vars.salvado_br);
        } catch (IOException e) {
            System.out.println(vars.erro + vars.n + e);
        }
    }
}
