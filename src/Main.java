import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        //OBS: Este primeiro pedaco de codigo eh apenas para adicionar autmaticamente nomes e enderecos aleatorios,
        // tem o intuito de falicitar nos testes
        //||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||

        List <pessoa> pessoas = new ArrayList<>();
        String[] nomes = {"João", "Maria", "Pedro", "Ana", "Lucas", "Isabela", "Mariana", "Rafael", "Lara", "Tiago",
                "Camila", "Gustavo", "Bianca", "Diego", "Carolina", "Thiago", "Juliana", "Eduardo", "Natália",
                "Marcelo", "Vitória", "Roberto", "Fernanda", "Hugo", "Lorena", "Leonardo", "Beatriz", "Ricardo",
                "Amanda"};
        int numPessoasAleatorias = 30;
        int numEnderecosAleatorios = 2;


        Random random = new Random();

        for (int i = 0; i < numPessoasAleatorias; i++) {
            String nomeAleatorio = nomes[random.nextInt(nomes.length)];
            int idadeAleatoria = random.nextInt(80) + 1; // Idade entre 1 e 80 anos
            List<Enderecos> enderecosAleatorios = new ArrayList<>();

            for (int j = 0; j < numEnderecosAleatorios; j++) {
                String ruaAleatoria = "Rua " + (j + 1);
                Integer numeroAleatorio = random.nextInt(1000) + 1; // Número entre 1 e 1000

                Enderecos endereco = new Enderecos(ruaAleatoria, numeroAleatorio);
                enderecosAleatorios.add(endereco);
            }

            pessoa pessoa = new pessoa(nomeAleatorio, idadeAleatoria, enderecosAleatorios);
            pessoas.add(pessoa);
        }

// ||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||




        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println( "|||||| LISTA DE PESSOAS / ENDERECOS ||||||");

            System.out.println( "1| Listar Todas as Pessoas");
            System.out.println( "2| Buscar por nome e imprimir dados");
            System.out.println( "3| Adicionar");
            System.out.println( "4| Excluir");
            System.out.println( "5| Alterar");


            Integer op1 = scanner.nextInt();


            switch (op1){
                case 1 :
                    boolean pesquisa = true;
                    System.out.println( "|||||| LISTA DE PESSOAS / ENDERECOS ||||||");
                    for ( int i = 0; i < pessoas.size(); i ++) {

                        Integer index = pessoas.indexOf(pessoas.get(i)) + 1;
                        System.out.println( index+ "--| " + pessoas.get(i).getNome());
                    }


                    break;

                case 2 :

                    System.out.println("Digite o nome que deseja imprimir os dados");
                    List<Integer> encontrados = new ArrayList<>();
                    scanner.nextLine();
                    String nome_pesquisa = scanner.nextLine();

                    for ( int i = 0; i < pessoas.size(); i++) {
                        pessoa pessoa_pesquisa = pessoas.get(i);
                        if ( pessoa_pesquisa.getNome().toLowerCase(Locale.ROOT).equals(nome_pesquisa.toLowerCase())) {

                            encontrados.add(pessoas.indexOf(pessoa_pesquisa));

                        }
                    }

                    if (encontrados.size() > 0 ){
                        for ( int i = 0; i < encontrados.size(); i++) {
                            Integer index_encontrados = pessoas.indexOf(pessoas.get(encontrados.get(i)));
                            System.out.println( index_encontrados +"| "+ pessoas.get(encontrados.get(i)).getNome());
                        }

                        if ( encontrados.size() > 1) {
                            boolean case2 = true;
                            Integer pessoa_print;
                            System.out.println(" digite o index de quem voce deseja imprimir os dados");
                            do{
                                pessoa_print = scanner.nextInt();

                                if (pessoas.get(pessoa_print) == null) {
                                    System.out.println("esse index nao existe, por favor escolha novamente");
                                } else {
                                    case2 = false;
                                }
                            }while (case2);

                            System.out.println( "Nome:" + pessoas.get(pessoa_print).getNome() + "  Idade: " + pessoas.get(pessoa_print).getIdade());
                            pessoa pessoa_selected = pessoas.get(pessoa_print);
                            for (int i = 0; i < pessoa_selected.getEnderecos().size(); i++){
                                Integer endereco_index =  i+1;
                                String rua_sected = pessoa_selected.getEnderecos().get(i).getRua();
                                Integer numero_selected = pessoa_selected.getEnderecos().get(i).getNumero();
                                System.out.println( "Endereco | "+endereco_index+" |");
                                System.out.println("    Rua: " + rua_sected);
                                System.out.println("    Numero: "+ numero_selected);

                            }



                        } else if ( encontrados.size() == 1) {

                            System.out.println( "Nome:" + pessoas.get(encontrados.get(0)).getNome() + "  Idade: " + pessoas.get(encontrados.get(0)).getIdade());
                            pessoa pessoa_selected = pessoas.get(encontrados.get(0));
                            for (int i = 0; i < pessoa_selected.getEnderecos().size(); i++){
                                Integer endereco_index =  i+1;
                                String rua_sected = pessoa_selected.getEnderecos().get(i).getRua();
                                Integer numero_selected = pessoa_selected.getEnderecos().get(i).getNumero();
                                System.out.println( "Endereco | "+endereco_index+" |");
                                System.out.println("    Rua: " + rua_sected);
                                System.out.println("    Numero: "+ numero_selected);

                            }
                        }





                    } else {

                        System.out.println("Nome nao encontrado, por favor, tente novamente");

                    }


                    System.out.println( " ");
                    System.out.println( " ");
                    System.out.println( " ");
                    System.out.println( " 0 | VOLTAR");
                    Integer voltar;
                    do {
                         voltar = scanner.nextInt();
                    }while ( voltar != 0);
                    break;

                case 3 :

                    String nome;
                    Integer idade;
                    Integer num_enderecos;
                    String rua;
                    Integer numero;
                    List<Enderecos> enderecos = new ArrayList<>();

                    scanner.nextLine();
                    System.out.println("Nome: ");
                    nome = scanner.nextLine();
                    System.out.println("Idade: ");
                    idade = scanner.nextInt();

                    System.out.println("numero de enderecos: ");
                    num_enderecos = scanner.nextInt();
                    scanner.nextLine();

                    for( Integer j = 0; j < num_enderecos ; j++) {
                        Enderecos end = new Enderecos();
                        System.out.println("Rua: ");
                        rua = scanner.nextLine();
                        System.out.println("Numero: ");
                        numero = scanner.nextInt();

                        scanner.nextLine();

                        end.setRua(rua);
                        end.setNumero(numero);
                        enderecos.add(end);
                    }
                    pessoas.add( new pessoa(nome, idade, enderecos));


                    break;


                case 4 :

                    System.out.println("quem voce deseja excluir? ");

                    List<Integer> encontrados2 = new ArrayList<>();
                    scanner.nextLine();
                    String nome_pesquisa2 = scanner.nextLine();

                    for ( int i = 0; i < pessoas.size(); i++) {
                        pessoa pessoa_pesquisa = pessoas.get(i);
                        if ( pessoa_pesquisa.getNome().toLowerCase(Locale.ROOT).equals(nome_pesquisa2.toLowerCase())) {

                            encontrados2.add(pessoas.indexOf(pessoa_pesquisa));

                        }
                    }

                    if (encontrados2.size() > 0 ){
                        for ( int i = 0; i < encontrados2.size(); i++) {
                            Integer index_encontrados = pessoas.indexOf(pessoas.get(encontrados2.get(i)));
                            System.out.println( index_encontrados +"| "+ pessoas.get(encontrados2.get(i)).getNome());
                        }

                        if ( encontrados2.size() == 1) {


                            System.out.println(" deseja mesmo excluir "+ pessoas.get(encontrados2.get(0)).getNome()+" ?" );
                            System.out.println( " 1 | SIM");
                            System.out.println( " 2 | NAO");
                            Integer excluir;

                            do {
                                excluir = scanner.nextInt();
                            }while (excluir != 1 && excluir != 2);

                            if( excluir == 1) {
                                pessoa pessoa_excluida = pessoas.get(encontrados2.get(0));
                                pessoas.remove(pessoa_excluida);
                                System.out.printf("Pessoa excluida com sucesso");
                            }

                            if ( excluir == 2 ) {
                                break;
                            }

                        if ( encontrados2.size() > 1) {
                            boolean case2 = true;
                            Integer pessoa_print;
                            System.out.println(" digite o index de quem voce deseja excluir");
                            do{
                                pessoa_print = scanner.nextInt();

                                if (pessoas.get(pessoa_print) == null) {
                                    System.out.println("esse index nao existe, por favor escolha novamente");
                                } else {
                                    case2 = false;
                                }
                            }while (case2);

                            System.out.println(" deseja mesmo excluir "+ pessoas.get(pessoa_print).getNome()+" ?" );
                            System.out.println( " 1 | SIM");
                            System.out.println( " 2 | NAO");


                            do {
                                excluir = scanner.nextInt();
                            }while (excluir != 1 && excluir != 2);

                            if( excluir == 1) {
                                pessoa pessoa_excluida = pessoas.get(pessoa_print);
                                pessoas.remove(pessoa_excluida);
                                System.out.printf("Pessoa excluida com sucesso");
                            }

                            if ( excluir == 2 ) {
                                break;
                            }

                            }



                        }

                    } else {

                        System.out.println("Nome nao encontrado, por favor, tente novamente");

                    }


                    System.out.println( " ");
                    System.out.println( " ");
                    System.out.println( " ");
                    System.out.println( " 0 | VOLTAR");
                    Integer voltar2;
                    do {
                        voltar2 = scanner.nextInt();
                    }while ( voltar2 != 0);

                    break;

            }


        } while ( true );



    }
}