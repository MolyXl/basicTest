package pattern.decorator;

/**
 * @author MaZhuli
 * @description 艺术包装
 * @date 2019/6/25
 */
public class ArtWrapper extends GirlWrapper {
    private Girl girl;

    public ArtWrapper(Girl girl) {
        this.girl = girl;
    }

    @Override
    public String getDescription() {
        return girl.getDescription() + "art";
    }

    public static void main(String[] args) {
        Girl girl = new BeautifulGirl();
        ArtWrapper artWrapper = new ArtWrapper(girl);
        String description = artWrapper.getDescription();
        System.out.println(description);
    }
}
