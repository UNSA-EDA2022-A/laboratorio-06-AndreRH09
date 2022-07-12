package com.example.project;

public class Exercise2 {

    public static void main(String[] args) {
        Exercise2 obj = new Exercise2();

        BST<Integer> tree1 = new BST<Integer>();
        BST<Integer> tree2 = new BST<Integer>();

        Integer array [] = {1, 2,3, 4, 5};

        for(Integer value : array){
            tree1.insert(value);
            tree2.insert(value);
        }

        System.out.print(obj.bstIguales(tree1, tree2));
        
    }


    public <T extends Comparable<T>> boolean bstIguales(BST<T> a1, BST<T> a2){
        
        //Se envia la raiz de ambos arboles
        return bstNodoIgual(a1.root, a2.root);
    }
    
    public <T extends Comparable<T>> boolean bstNodoIgual(Node<T> node1, Node<T> node2){
        //Si se ha llegado a un nodo hoja en ambos arboles y se desciende
        //en ambos nodos deberian ser nulos, entonces aun es similar
        if(node1 == null && node2 == null)
            return true;
        
        //Si se ha llegado a un nodo hoja en 1 o 2 arbol pero el otro aun posee hijos
        //Entonces no son similares
        if(node1 == null || node2 == null)
            return false;
        
        //Si la data de el nodo del Arbol 1 es diferente a la data del arbol 2
        if(node1.data.compareTo(node2.data) != 0)
            return false;
            
        //Se desciende y compara en el subarbol izquierdo y en el derecho de los 2 BST de forma recursiva
        //Si una ocurrencia es falsa, entonces el operador && compromete el resultado a false
        return (bstNodoIgual(node1.left, node2.left) && bstNodoIgual(node1.right, node2.right));
    }
}
