import org.w3c.dom.Node;

/**
 * This Queue maintains the queue of messages coming from connected clients.
 */
public class P2PMessageQueue {

    private P2PMessage head = null;
    private P2PMessage tail = null;


    /**
     * This method allows adding a message object to the existing queue.
     * @param oMessage
     */
    public synchronized void enqueue(P2PMessage oMessage){

//		#####################
//		### ADD CODE HERE ###
//		#####################

        // validate if the queue is empty
        if(hasNodes()){
            // if the queue is empty
            this.head = this.tail = oMessage;
            return;
        }

        // add the new node to the start of the queue
        this.tail.next = oMessage;
        this.tail = oMessage;

    }


    /**
     * This method allows removing a message object from the existing queue.
     * @return
     */
    public synchronized P2PMessage dequeue(){

//		#####################
//		###  CODE HERE    ###
//		#####################

        // validation for queue
        if(hasNodes()){
            System.out.println("[queue] No messages in queue.");
            return null;
        }

        // store the previous head node and move it up one step
        P2PMessage oTemp = this.head;
        this.head = this.head.next;

        // If the head becomes null then the tail must also be null right?
        if(this.head == null){
            this.tail = null;
        }
        return oTemp; // return our dequeued node/message

    }


    public boolean hasNodes(){

//		#####################
//		### ADD CODE HERE ###
//		#####################
        boolean bFlag = true;

        if(this.tail == null)
            bFlag = false;

        else if(this.head == null)
            bFlag = false;

        return bFlag; // will return the boolean checking if the node is null or not
    }
}

