package cs;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String choice = "";
        while(!choice.equalsIgnoreCase("X")) {
            initialMenu();
            choice = scan.nextLine();
            if(choice.equals("1")) {
                editString(scan);
            } else if(choice.equals("2")) {
                stackArray(scan);
            } else if(choice.equals("3")) {
                stackLinkedList(scan);
            } else if(choice.equals("4")) {
                stackArrayList(scan);
            } else if(choice.equalsIgnoreCase("X")) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
        scan.close();
    }

    /**
     * editString Allows a user to input a String, wherein the characters are pushed into a StackArray object. The
     * user is presented with options to convert the String to all uppercase, all lowercase, reverse characters,
     * swap all occurrences of one character with another, and undo the previous change.
     */
    public static void editString(Scanner s) {
        System.out.print("CENTURY STACK - MODIFY A MESSAGE USING THE STACK\nEnter a message: ");
        String str = s.nextLine();
        CenturyStackInterface<Character> stk1 = new StackArray<>();
        CenturyStackInterface<Character> stk2 = new StackArray<>();
        for(int i = 0; i < str.length(); i++) {
            stk1.push(str.charAt(i));
        }
        String displayedStack = "stk1";
        String choice = "null";
        while(!choice.equals("X")) {
            System.out.print("Operations:\nU - Make all letters uppercase\nL - Make all letters lowercase\n" +
                    "R - Reverse the string\nC ch1 ch2 - Change all occurrences of ch1 to ch2\nZ - Undo the most " +
                    "recent change\nX - Terminate\nEnter choice: ");
            choice = s.nextLine();
            switch(choice) {
                case "U":
                    if(displayedStack.equals("stk1")) {
                        if(!stk2.isEmpty()) {
                            stk2.clear();
                        }
                        for(int i = 0; i < str.length(); i++) {
                            stk2.push(Character.toUpperCase(str.charAt(i)));
                        }
                        displayedStack = "stk2";
                        str = stk2.editContents();
                        System.out.println(str);
                    } else {
                        if(!stk1.isEmpty()) {
                            stk1.clear();
                        }
                        for(int i = 0; i < str.length(); i++) {
                            stk1.push(Character.toUpperCase(str.charAt(i)));
                        }
                        displayedStack = "stk1";
                        str = stk1.editContents();
                        System.out.println(str);
                    }
                    break;
                case "L":
                    if(displayedStack.equals("stk1")) {
                        if(!stk2.isEmpty()) {
                            stk2.clear();
                        }
                        for(int i = 0; i < str.length(); i++) {
                            stk2.push(Character.toLowerCase(str.charAt(i)));
                        }
                        displayedStack = "stk2";
                        str = stk2.editContents();
                        System.out.println(str);
                    } else {
                        if(!stk1.isEmpty()) {
                            stk1.clear();
                        }
                        for(int i = 0; i < str.length(); i++) {
                            stk1.push(Character.toLowerCase(str.charAt(i)));
                        }
                        displayedStack = "stk1";
                        str = stk1.editContents();
                        System.out.println(str);
                    }
                    break;
                case "R":
                    if(displayedStack.equals("stk1")) {
                        if(!stk2.isEmpty()) {
                            stk2.clear();
                        }
                        for(int i = str.length() - 1; i >= 0; i--) {
                            stk2.push(str.charAt(i));
                        }
                        str = stk2.editContents();
                        System.out.println(str);
                        displayedStack = "stk2";
                    } else {
                        if(!stk1.isEmpty()) {
                            stk1.clear();
                        }
                        for(int i = str.length() - 1; i >= 0; i--) {
                            stk1.push(str.charAt(i));
                        }
                        str = stk1.editContents();
                        System.out.println(str);
                        displayedStack = "stk1";
                    }
                    break;
                case "C":
                    System.out.print("ch1: ");
                    String char1String = s.nextLine();
                    System.out.print("ch2: ");
                    String char2String = s.nextLine();
                    char ch1 = char1String.charAt(0);
                    char ch2 = char2String.charAt(0);
                    if(displayedStack.equals("stk1")) {
                        if(!stk2.isEmpty()) {
                            stk2.clear();
                        }
                        for(int i = 0; i < str.length(); i++) {
                            if(str.charAt(i) == ch1) {
                                stk2.push(ch2);
                            } else {
                                stk2.push(str.charAt(i));
                            }
                        }
                        displayedStack = "stk2";
                        str = stk2.editContents();
                        System.out.println(str);
                    } else {
                        if(!stk1.isEmpty()) {
                            stk1.clear();
                        }
                        for(int i = 0; i < str.length(); i++) {
                            if(str.charAt(i) == ch1) {
                                stk1.push(ch2);
                            } else {
                                stk1.push(str.charAt(i));
                            }
                        }
                        displayedStack = "stk1";
                        str = stk1.editContents();
                        System.out.println(str);
                    }
                    break;
                case "Z":
                    if(displayedStack.equals("stk1")) {
                        displayedStack = "stk2";
                        str = stk2.editContents();
                        System.out.println(str);
                    } else {
                        displayedStack = "stk1";
                        str = stk1.editContents();
                        System.out.println(str);
                    }
                    break;
                case "X":
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
    public static void stackArray(Scanner s) {
        CenturyStackInterface<Integer> sa = new StackArray<>();
        String choice = "";
        while(!choice.equalsIgnoreCase("X")) {
            stackArrayMenu();
            choice = s.nextLine();
            if(choice.equals("1")) {
                System.out.print("Enter an integer to push on the stack: ");
                int input = s.nextInt();
                s.nextLine();
                sa.push(input);
                System.out.println("Pushed: " + sa.peek());
            } else if(choice.equals("2")) {
                int removed = sa.peek();
                sa.pop();
                System.out.println("Popped: " + removed);
            } else if(choice.equals("3")) {
                System.out.println("Peeked: " + sa.peek());
            } else if(choice.equals("4")) {
                System.out.println("Empty stack: " + sa.isEmpty());
            } else if(choice.equals("5")) {
                System.out.println("Full stack: " + sa.isFull());
            } else if(choice.equals("6")) {
                sa.clear();
                System.out.println("Cleared: " + sa.isEmpty());
            } else if(choice.equals("7")) {
                if(sa.isEmpty()) {
                    System.out.println("Not enough elements.");
                } else {
                    sa.swapStart();
                    System.out.println("Swapped");
                }
            } else if(choice.equals("8")) {
                System.out.println(sa.toString());
            } else if(choice.equalsIgnoreCase("X")) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }
    public static void stackLinkedList(Scanner s) {
        CenturyStackInterface<Integer> lls = new LinkedListStack<>();
        String choice = "";
        while(!choice.equalsIgnoreCase("X")) {
            stackLinkedMenu();
            choice = s.nextLine();
            if(choice.equals("1")) {
                System.out.print("Enter an integer to push on the stack: ");
                int input = s.nextInt();
                s.nextLine();
                lls.push(input);
                System.out.println("Pushed: " + lls.peek());
            } else if(choice.equals("2")) {
                int removed = lls.peek();
                lls.pop();
                System.out.println("Popped: " + removed);
            } else if(choice.equals("3")) {
                System.out.println("Peeked: " + lls.peek());
            } else if(choice.equals("4")) {
                System.out.println("Empty stack: " + lls.isEmpty());
            } else if(choice.equals("5")) {
                System.out.println("Full stack: " + lls.isFull());
            } else if(choice.equals("6")) {
                lls.clear();
                System.out.println("Cleared: " + lls.isEmpty());
            } else if(choice.equals("7")) {
                if(lls.isEmpty()) {
                    System.out.println("Not enough elements.");
                } else {
                    lls.swapStart();
                    System.out.println("Swapped");
                }
            } else if(choice.equals("8")) {
                System.out.println(lls.toString());
            } else if(choice.equalsIgnoreCase("X")) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }
    public static void stackArrayList(Scanner s) {
        CenturyStackInterface<Integer> sal = new StackArrayList<>();
        String choice = "";
        while(!choice.equalsIgnoreCase("X")) {
            stackArrayListMenu();
            choice = s.nextLine();
            if(choice.equals("1")) {
                System.out.print("Enter an integer to push on the stack: ");
                int input = s.nextInt();
                s.nextLine();
                sal.push(input);
                System.out.println("Pushed: " + sal.peek());
            } else if(choice.equals("2")) {
                int removed = sal.peek();
                sal.pop();
                System.out.println("Popped: " + removed);
            } else if(choice.equals("3")) {
                System.out.println("Peeked: " + sal.peek());
            } else if(choice.equals("4")) {
                System.out.println("Empty stack: " + sal.isEmpty());
            } else if(choice.equals("5")) {
                System.out.println("Full stack: " + sal.isFull());
            } else if(choice.equals("6")) {
                sal.clear();
                System.out.println("Cleared: " + sal.isEmpty());
            } else if(choice.equals("7")) {
                if(sal.isEmpty()) {
                    System.out.println("Not enough elements.");
                } else {
                    sal.swapStart();
                    System.out.println("Swapped");
                }
            } else if(choice.equals("8")) {
                System.out.println(sal.toString());
            } else if(choice.equalsIgnoreCase("X")) {
                break;
            } else {
                System.out.println("Invalid choice.");
            }
        }
    }

    /**
     * initialMenu The general menu of options.
     */
    public static void initialMenu() {
        System.out.print("Stack ADT Implementations\n1 - Century Stack - Modify a String using Stacks!\n2 - " +
                "Test Driver for Stack (Array Implementation)\n3 - Test Driver for Stack (Linked List " +
                "Implementation)\n4 - Test Driver for Stack (ArrayList Implementation)\nX - Terminate\nEnter " +
                "choice: ");
    }

    /**
     * stackArrayMenu The menu of options for Stack implemented with an array.
     */
    public static void stackArrayMenu() {
        System.out.print("Methods for Stack (Array Implementation)\n1 - PUSH - Add an integer to the top " +
                "of the stack\n2 - POP - Remove an integer from the top of the stack\n3 - PEEK - " +
                "Observe the integer at the top of the stack\n4 - IS EMPTY - Check if the stack is empty\n" +
                "5 - IS FULL - Check if the stack is full\n6 - CLEAR - Remove all elements in the stack\n" +
                "7 - SWAP START - Swap the two integers at the top of the stack\n8 - TO STRING - Relay the " +
                "current representation of the stack\nX - Terminate\n\nEnter choice: ");
    }

    /**
     * stackLinkedMenu The menu of options for Stack implemented with a Linked List.
     */
    public static void stackLinkedMenu() {
        System.out.print("Methods for Stack (Linked List Implementation)\n1 - PUSH - Add an integer to the top" +
                " of the stack\n2 - POP - Remove an integer from the top of the stack\n3 - PEEK - " +
                "Observe the integer at the top of the stack\n4 - IS EMPTY - Check if the stack is empty\n" +
                "5 - IS FULL - Check if the stack is full\n6 - CLEAR - Remove all elements in the stack\n" +
                "7 - SWAP START - Swap the two integers at the top of the stack\n8 - TO STRING - Relay the " +
                "current representation of the stack\nX - Terminate\n\nEnter choice: ");
    }

    /**
     * stackArrayListMenu The menu of options for Stack implemented with an ArrayList.
     */
    public static void stackArrayListMenu() {
        System.out.print("Methods for Stack (ArrayList Implementation)\n1 - PUSH - Add an integer to the top" +
                " of the stack\n2 - POP - Remove an integer from the top of the stack\n3 - PEEK - " +
                "Observe the integer at the top of the stack\n4 - IS EMPTY - Check if the stack is empty\n" +
                "5 - IS FULL - Check if the stack is full\n6 - CLEAR - Remove all elements in the stack\n" +
                "7 - SWAP START - Swap the two integers at the top of the stack\n8 - TO STRING - Relay the " +
                "current representation of the stack\nX - Terminate\n\nEnter choice: ");
    }
}
