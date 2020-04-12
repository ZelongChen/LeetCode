package leetcode.solutions.Easy;

public class DefangingAnIPAddress {
    public String defangIPaddr(String address) {
        return address.replace(".", "[.]");
    }
}