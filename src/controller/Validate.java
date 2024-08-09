package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Validate {
    private static final String PRICE_PRODUCT_REGEX = "^(3000(\\.0+)?|[1-9][0-9]{0,2}(\\.\\d+)?|[1-2][0-9]{3}(\\.\\d+)?)$\n";
    private static final String COLOR_PRODUCT_REGEX = "^(red|blue|green|yellow|purple|pink|orange|black|white|gray|grey|brown|cyan|magenta|lime|olive|maroon|navy|teal|aqua|fuchsia|silver|gold|beige|coral|indigo|ivory|khaki|lavender|plum|salmon|tan|violet)$\n";
    private static final String IMEI_PRODUCT_REGEX = "^\\d{1,6}$\n";
    private static final String CAPACITY_PRODUCT_REGEX = "^(0|16|32|64|128|256|512|1024)$\n";
    private static final String NAME_PRODUCT_REGEX = "^[A-Za-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠƯàáâãèéêìíòóôõùúăđĩũơưẮẰẲẴẶẮẤẦẨẪẬẸẺẼỀỀỂỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪỬỮỰ0-9 ]{1,50}$\n";

    public static boolean ValidatePrice(String price) {
        Pattern pattern = Pattern.compile(PRICE_PRODUCT_REGEX);
        Matcher matcher = pattern.matcher(price);
        return matcher.matches();
    }

    public static boolean ValidateColor(String color) {
        Pattern pattern = Pattern.compile(COLOR_PRODUCT_REGEX);
        Matcher matcher = pattern.matcher(String.valueOf(color));
        return matcher.matches();
    }

    public static boolean ValidateImeiProduct(String imei) {
        Pattern pattern = Pattern.compile(IMEI_PRODUCT_REGEX);
        Matcher matcher = pattern.matcher(String.valueOf(imei));
        return matcher.matches();
    }

    public static boolean ValidateName(String name) {
        Pattern pattern = Pattern.compile(NAME_PRODUCT_REGEX);
        Matcher matcher = pattern.matcher(String.valueOf(name));
        return matcher.matches();
    }

    public static boolean ValidateCapacity(String capacity) {
        Pattern pattern = Pattern.compile(CAPACITY_PRODUCT_REGEX);
        Matcher matcher = pattern.matcher(String.valueOf(capacity));
        return matcher.matches();
    }
}
