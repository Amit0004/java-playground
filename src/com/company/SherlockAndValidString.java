package com.company;

import java.util.*;

public class SherlockAndValidString {

    public static String isValid(String s) {
        Map<Character, Integer> frequency = new HashMap<>();
        Map<Integer, Set<Character>> freqToChar = new HashMap<>();
        Set<Integer> numbers = new HashSet<>();

        for(int i = 0; i < s.length(); i++) {
            frequency.put(s.charAt(i), frequency.getOrDefault(s.charAt(i), 0) + 1);
        }
        for(Map.Entry<Character, Integer> k : frequency.entrySet()) {
            if(freqToChar.containsKey(k.getValue())) {
                freqToChar.get(k.getValue()).add(k.getKey());
            } else {
                freqToChar.putIfAbsent(k.getValue(), new HashSet<>());
                freqToChar.get(k.getValue()).add(k.getKey());
            }
            System.out.println(k.getKey() + " : " + k.getValue());
        }
        System.out.println("--------------------------");
        for(Map.Entry<Integer, Set<Character>> entry : freqToChar.entrySet()) {
            System.out.println(entry.getKey() + " : " + entry.getValue().size());
        }
        System.out.println("--------------------------");
        List<Integer> set = new ArrayList<>();
        numbers.addAll(frequency.values());
        set.addAll(numbers);
        if(numbers.size() == 1) {
            return "YES";
        } else if(numbers.size() > 2) {
            return "NO";
        } else {
            int s1 = freqToChar.get(set.get(0)).size();
            int s2 = freqToChar.get(set.get(1)).size();
            if(Math.abs(set.get(0) - set.get(1)) == 1 && (s1 == 1 || s2 == 1)) {
                return "YES";
            } else if((s1 == 1 && s2 != 1) || (s2 == 1 && s1 != 1)) {
                return "YES";
            } else {
                return "NO";
            }
        }
    }

    public static void main(String[] args) {
        SherlockAndValidString svs = new SherlockAndValidString();
        String input =  "ibfdgaeadiaefgbhbdghhhbgdfgeiccbiehhfcggchgghadhdhagfbahhddgghbdehidbibaeaagaeeigffcebfbaieggabcfbiiedcabfihchdfabifahcbhagccbdfifhghcadfiadeeaheeddddiecaicbgigccageicehfdhdgafaddhffadigfhhcaedcedecafeacbdacgfgfeeibgaiffdehigebhhehiaahfidibccdcdagifgaihacihadecgifihbebffebdfbchbgigeccahgihbcbcaggebaaafgfedbfgagfediddghdgbgehhhifhgcedechahidcbchebheihaadbbbiaiccededchdagfhccfdefigfibifabeiaccghcegfbcghaefifbachebaacbhbfgfddeceababbacgffbagidebeadfihaefefegbghgddbbgddeehgfbhafbccidebgehifafgbghafacgfdccgifdcbbbidfifhdaibgigebigaedeaaiadegfefbhacgddhchgcbgcaeaieiegiffchbgbebgbehbbfcebciiagacaiechdigbgbghefcahgbhfibhedaeeiffebdiabcifgccdefabccdghehfibfiifdaicfedagahhdcbhbicdgibgcedieihcichadgchgbdcdagaihebbabhibcihicadgadfcihdheefbhffiageddhgahaidfdhhdbgciiaciegchiiebfbcbhaeagccfhbfhaddagnfieihghfbaggiffbbfbecgaiiidccdceadbbdfgigibgcgchafccdchgifdeieicbaididhfcfdedbhaadedfageigfdehgcdaecaebebebfcieaecfagfdieaefdiedbcadchabhebgehiidfcgahcdhcdhgchhiiheffiifeegcfdgbdeffhgeghdfhbfbifgidcafbfcd";
//        String input = "aabbccddeefghi";
        System.out.println(svs.isValid(input));
    }
}
