package CarPooling;

// 1094. Car Pooling
//     You are driving a vehicle that has capacity empty seats initially available for passengers.
//     The vehicle only drives east (ie. it cannot turn around and drive west.)
//
//     Given a list of trips, trip[i] = [num_passengers, start_location, end_location] contains information about the i-th
//     trip: the number of passengers that must be picked up, and the locations to pick them up and drop them off.
//     The locations are given as the number of kilometers due east from your vehicle's initial location.
//
//     Return true if and only if it is possible to pick up and drop off all passengers for all the given trips.
//
//   Example
//    Input: trips = [[2,1,5],[3,3,7]], capacity = 4
//    Output: false


public class Solution {
    class Node {
        int num;
        int kilos;
        Node next;
    }

    public boolean carPooling(int[][] trips, int capacity) {
        Node head = new Node();
        head.next = null;
        for(int[] trip : trips) {
            insert(head, trip[0], trip[1]);
            insert(head, -trip[0], trip[2]);
        }
        Node node = head.next;
        int passengersInCar = 0;
        while (node != null) {
            passengersInCar += node.num;
            if(passengersInCar > capacity)
                return false;
            node = node.next;
        }
        return true;
    }

    private void insert(Node head, int num, int kilos) {
        Node node = new Node();
        node.kilos = kilos;
        node.num = num;
        node.next = null;
        Node now = head.next;
        Node pre = head;
        while(now != null && now.kilos <= kilos) {
            if(kilos == now.kilos) {
                now.num += num;
                return;
            }
            pre = now;
            now = pre.next;
        }
        pre.next = node;
        node.next = now;
    }
}
