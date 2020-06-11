package arithmetic.structure;

import java.util.Objects;

/**
 * @author mazhuli
 * @date 2020/6/10
 * @desc ${description}
 */
public class HashTest {
    private Integer value;
    private Integer hash;

    public Integer getValue() {
        return value;
    }

    public void setValue(Integer value) {
        this.value = value;
    }

    public Integer getHash() {
        return hash;
    }

    public void setHash(Integer hash) {
        this.hash = hash;
    }

    public HashTest(Integer value, Integer hash) {
        this.value = value;
        this.hash = hash;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HashTest hashTest = (HashTest) o;
        return Objects.equals(value, hashTest.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(hash);
    }
}
