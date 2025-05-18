package coreJava;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class SerializationExample {
    public static void main(String[] args) {
        // Creating an object to be serialized
        MyClass objectToSerialize = new MyClass("Hello, Serialization!");

        // Serializing the object into an array of bytes
        byte[] serializedData = serializeObject(objectToSerialize);

        // Deserialize the array of bytes back into an object
        MyClass deserializedObject = deserializeObject(serializedData);

        // Print the deserialized data
        System.out.println("Deserialized Data: " + deserializedObject.getData());
    }

    private static byte[] serializeObject(Serializable object) {
        try (ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
             ObjectOutputStream objectOutputStream = new ObjectOutputStream(byteArrayOutputStream)) {

            // Writing the object to the ByteArrayOutputStream
            objectOutputStream.writeObject(object);

            // Returning the byte array
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }

    private static MyClass deserializeObject(byte[] data) {
        try (ObjectInputStream objectInputStream = new ObjectInputStream(new ByteArrayInputStream(data))) {

            // Reading the object from the byte array
            return (MyClass) objectInputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}

class MyClass implements Serializable {
    private static final long serialVersionUID = 1L;
    private String data;

    public MyClass(String data) {
        this.data = data;
    }

    public String getData() {
        return data;
    }
}

