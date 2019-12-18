package Review.ClassExe;


class Out {

    public class In {
        public int i = 10;

        {
            System.out.println("In code");
        }
    }

    public In getIn() {
        return new In();
    }

    static {
        System.out.println("Out static code");
    }
}

class Other {
    public Other() {
        //I want the number i in In
        //In是内部类，必须通过他的外部类才能拿到
        Out.In in = (new Out()).getIn();
        System.out.println(in.i);
    }

    static {
        System.out.println("Other static code");
    }
}
public class ClassTest {
    public static void main(String[] args) {
        Other other = new Other();
    }
}
