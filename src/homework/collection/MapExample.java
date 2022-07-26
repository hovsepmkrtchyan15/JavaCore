package homework.collection;

import java.util.*;

public class MapExample {


    public static void main(String[] args) {
        List<FootballTeamMember> members = new ArrayList<>();
        members.add(new FootballTeamMember(1, "aaa"));
        members.add(new FootballTeamMember(2, "bbb"));
        members.add(new FootballTeamMember(3, "ccc"));
        members.add(new FootballTeamMember(4, "ddd"));
        createFootballTeam(members);



    }

    //Ունենք FootballTeamMember-ի լիստ, պետք է ստանանք HashMap որտեղ կեյ-ը կլինի խաղացողի համարը, իսկ վելյուն իրա անունը։
    static Map<Integer, String> createFootballTeam(List<FootballTeamMember> members) {
        Map<Integer, String> hashMape = new HashMap<>();
        for (FootballTeamMember member : members) {
            hashMape.put(member.getNumber(), member.getName());
        }

        return hashMape;
    }


    //Մեթոդի մեջ պետք է տրված մապ-ից ջնջենք removedNumber համարը եթե կա, ու վերադարձնենք true, եթե չկա վերադարձնենք false
    static boolean removeFromMap(Map<Integer, String> memberMap, Integer removedNumber) {
        for (Integer integer : memberMap.keySet()) {
            if (integer != removedNumber) {
                return false;
            }

        }
        return true;
    }

    //Մեթոդով տպելու ենք միայն անունները
    static void printAllMemberNames(Map<Integer, String> memberMap) {
        Collection<String> list = memberMap.values();

        for (String value : memberMap.values()) {
            System.out.println(value);
        }
    }

    //Մեթոդով տպելու ենք թե համարը, թե խաղացողի անունը հետյալ ձև՝
// 11 - Poxos Poxosyan
// 12 - Petros Petrosyan
    static void printAllMembers(Map<Integer, String> memberMap) {
        for (Integer integer : memberMap.keySet()) {
            System.out.println(integer + "-" + memberMap.get(integer));

        }

    }


    static class FootballTeamMember {
        private int number;
        private String name;

        public FootballTeamMember(int number, String name) {
            this.number = number;
            this.name = name;
        }

        public int getNumber() {
            return number;
        }

        public void setNumber(int number) {
            this.number = number;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }


    }
}

