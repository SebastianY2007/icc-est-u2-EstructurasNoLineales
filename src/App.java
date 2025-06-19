import Materia.controllers.BinaryTree;

public class App {
    public static void main(String[] args) throws Exception {
        BinaryTree bT = new BinaryTree();
        bT.insert(50);
        bT.insert(17);
        bT.insert(76);
        bT.insert(9);
        bT.insert(23);
        bT.insert(54);
        bT.insert(14);
        bT.insert(19);

        System.out.println("Nombre: Sebastian Yupangui\n");
        System.out.println("Peso del arbol: " + bT.getWeight());
        System.out.println("Altura es: " + bT.getHeight() + " \n");

        System.out.println("Arbol InOrder");
        bT.printBinaryTree();
        System.out.println("\n");
        
        System.out.println("Arbol InOrder con aluras");
        bT.printHeight();
        System.out.println("\n");

        System.out.println("Arbol InOrder con factor de equilibrio");
        bT.printBalance();
        System.out.println("\n");

        System.out.println("Arbol esta equilibrado: " + bT.isBalanced());
        bT.insert(15);
        System.out.println("Agregamos valor: 15");
        System.out.println("\n");

        System.out.println("Arbol InOrder con factor de equilibrio");
        bT.printBalance();
        System.out.println("\n");
        bT.printUnbalancedNodes();
    }
} 