package com.example.project;

public class Exercise1 {

    public static void main(String[] args) {
        Exercise1 obj = new Exercise1();

        BST<Integer> tree1 = new BST<Integer>();
        BST<Integer> tree2 = new BST<Integer>();

        Integer array [] = {1, 2,3, 4, 5};

        for(Integer value : array){
            tree1.insert(value);
            tree2.insert(value);
        }

        System.out.print(obj.bstSimilares(tree1, tree2));
        
    }


    public <T extends Comparable<T>> boolean bstSimilares(BST<T> a1, BST<T> a2){
                //Retorna true si ambos BST vacios
        if(a1.isEmpty() && a2.isEmpty())
            return true;
        
        //Retorna false si 1 de ellos esta vacio, pero el otro contiene algun valor
        if(a1.isEmpty() || a2.isEmpty())
            return false;
        
        
        return bstNodoSimilar(a1.root, a2.root);
    }
    
    public <T extends Comparable<T>> boolean bstNodoSimilar(Node<T> node1, Node<T> node2){
        //Si se ha llegado a un nodo hoja en ambos arboles y se desciende
        //en ambos nodos deberian ser nulos, entonces aun es similar
        if(node1 == null && node2 == null)
            return true;
        
        //Si se ha llegado a un nodo hoja en 1 o 2 arbol pero el otro aun posee hijos
        //Entonces no son similares
        if(node1 == null || node2 == null)
            return false;
        
        //Se desciende y compara en el subarbol izquierdo y en el derecho de los 2 BST de forma recursiva
        //Si una ocurrencia es falsa, entonces el operador && compromete el resultado a false
        return (bstNodoSimilar(node1.left, node2.left) && bstNodoSimilar(node1.right, node2.right));
    }
}
