package com.example.project;

public class Exercise3 {

    public static void main(String[] args) {
        Exercise3 obj = new Exercise3();

        BST<Integer> tree = new BST<Integer>();

        Integer array [] = {1, 2,3, 4, 5};

        for(Integer value : array){
            tree.insert(value);
        }

        System.out.print(obj.bstEstrictamenteBinario(tree));
        
    }


    public <T extends Comparable<T>> boolean bstEstrictamenteBinario(BST<T> a){
        
        return nodoEstrictamentebinario(a.root);
    }
    
    public <T extends Comparable<T>> boolean nodoEstrictamentebinario(Node<T> nodo){
        //Si ambos hijos de un nodo son nulos , se esta en un nodo hoja
        //Que tambien es estrictamente binario
        if(nodo.left == null && nodo.right == null)
            return true;
        
        //Si el nodo izq es nulo pero el der no, no es estrictamente binario
        if(nodo.left == null && nodo.right != null)
            return false;
        
        //Si el nodo der es nulo pero el izq no, no es estrictamente binario
        if(nodo.right == null && nodo.left != null)
            return false;
        
        //Se desciende y compara en el subarbol izquierdo y derecho de forma recursiva
        //Si una ocurrencia es falsa, entonces el operador && compromete el resultado a false
        return (nodoEstrictamentebinario(nodo.left) && nodoEstrictamentebinario(nodo.right));
    }
}
