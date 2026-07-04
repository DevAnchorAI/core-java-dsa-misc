package src.com.java17;

public sealed class Vechile permits Car, Bike {
}
//A permitted subclass must be one of:
//
//final → cannot be extended
//sealed → restricts further inheritance
//non-sealed → removes the restriction

final class Car extends Vechile {

}

non-sealed  class Bike extends Vechile{

}