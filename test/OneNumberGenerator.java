import com.company.NumberGenerator;

public class OneNumberGenerator implements NumberGenerator {
    @Override
    public int range(int lower, int higher) {
        return 1;
    }
}
