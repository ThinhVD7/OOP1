package Exercise;


    abstract class Person{
        public abstract String Name();
        public abstract int Age();
    }

    class Girl extends Person{
        private String name;
        private int age;

        public String Name() {
            return name;
        }

        public int Age() {
            return age;
        }

        public String Sex(){
            return "Female";
        }
        public Girl(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Girl{" +
                    "name='" + Name() + '\'' +
                    ", age=" + Age() +
                    '}';
        }
    }

    class Boy extends Person{
        public String Sex(){return "Male";}
        private String name;
        private int age;

        public String Name() {
            return name;
        }

        public int Age() {
            return age;
        }

        public Boy(String name, int age) {
            this.name = name;
            this.age = age;
        }

        @Override
        public String toString() {
            return "Boy{" +
                    "name='" + Name() + '\'' +
                    ", age=" + Age() +
                    '}';
        }
    }
    public class OOP1{
        public static void main(String[] args) {
            Girl Anna = new Girl("Anna", 20);
            Girl Emma = new Girl("Emma", 22);
            Boy Jack = new Boy("Jack", 19);
            Boy Duo = new Boy("Duo", 31);
            System.out.println(Anna.toString());
            System.out.println(Emma.toString());
            System.out.println(Jack.toString());
            System.out.println(Duo.toString());
        }
    }

