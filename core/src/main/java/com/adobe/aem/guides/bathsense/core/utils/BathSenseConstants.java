package com.adobe.aem.guides.bathsense.core.utils;


/**
 * The type Canon constants.
 */
public final class BathSenseConstants {

    /**
     * Class for defining constant variables
     *
     * @author Prabhat Jain
     */
    /**
     * Constant for DAM Path
     */
    public static final String DAM_FILE_PATH = "/content/dam";

    /**
     * The constant CANON_DAM_FILE_PATH.
     */
    public static final String CANON_DAM_FILE_PATH = "/content/dam/canon";

    /**
     * The constant CANON_DAM_SUPPORT_VIDEOS_PATH.
     */
    public static final String CANON_DAM_SUPPORT_VIDEOS_PATH = "/content/dam/canon/support-videos";

    /**
     * The constant CONTENT_PATH.
     */
    public static final String CONTENT_PATH = "/content";
    /**
     * Constant for HTML extension
     */
    public static final String HTML_EXTN = ".html";

    /**
     * Constant for HTTP extension
     */
    public static final String HTTP = "http://";

    /**
     * Constant for HTTPS extension
     */
    public static final String HTTPS = "https://";

    /**
     * Constant for double slashes
     */
    public static final String SLASHES = "//";

    /**
     * Constant for single forward slash
     */
    public static final String SLASH = "/";

    /**
     * Constant for bumper colOneClass
     */
    public static final String COL_ONE_CLASS = "colOneClass";

    /**
     * Constant for bumper colTwoClass
     */
    public static final String COL_TWO_CLASS = "colTwoClass";

    /**
     * Constant for bumper colThreeClass
     */
    public static final String COL_THREE_CLASS = "colThreeClass";

    /**
     * Constant for bumper colFourClass
     */
    public static final String COL_FOUR_CLASS = "colFourClass";

    /**
     * Constant for bumper ONE
     */
    public static final String ONE = "1";

    /**
     * Constant for bumper TWO
     */
    public static final String TWO = "2";

    /**
     * Constant for bumper THREE
     */
    public static final String THREE = "3";

    /**
     * The constant ACCEPT.
     */
    public static final String ACCEPT = "accept";
    /**
     * The constant APPLICATION_JSON.
     */
    public static final String APPLICATION_JSON = "application/json";
    /**
     * The constant STATUS_OK.
     */
    public static final int STATUS_OK = 200;

    /**
     * The constant REJECT.
     */
    public static final String REJECT = "reject";

    /**
     * The constant STATUS_CREATED.
     */
    public static final int STATUS_CREATED = 201;

    /**
     * The constant XF_FOLDER_PATH.
     */
    public static final String XF_FOLDER_PATH = "/content/experience-fragments/canonxf/categorynav";

    /**
     * The constant XF_FOLDER_PATH_LEARNING.
     */
    public static final String XF_FOLDER_PATH_LEARNING = "/content/experience-fragments/canonxf/training";

    /**
     * The constant XF_HEADER_CONFIG_PATH.
     */
    public static final String XF_HEADER_CONFIG_PATH = "/content/experience-fragments/canon/global/header/master";

    /**
     * The constant JCR_CONTENT.
     */
    public static final String JCR_CONTENT = "/jcr:content";

    /**
     * The constant METADATA.
     */
    public static final String METADATA = "metadata";

    /**
     * The constant REQUIRED_METADATA_FIELDS.
     */
    public static final String[] REQUIRED_METADATA_FIELDS = new String[] { "dc:title", "dc:format", "psAux:OwnerName",
            "tiff:Model", "psAux:Lens", "exif:FNumber", "exif:ExposureTime", "exifEX:PhotographicSensitivity",
            "jcr:uuid", "social:facebooklink", "social:glassdoorlink", "social:instagramlink", "social:pintrestlink",
            "social:twitterlink", "social:linkedinlink", "social:youtubelink", "social:vimeolink", "dam:scene7Domain",
            "dam:scene7File" };

    /**
     * The constant REQUIRED_METADATA_FIELDS_PNS.
     */
    public static final String[] REQUIRED_METADATA_FIELDS_DSLR = new String[] { "exif:ShootingMode",
            "exif:ExposureTime", "exif:ApertureValue", "exif:MeteringMode", "exif:ISOSpeedRatings", "ns1:LensModel",
            "exif:FocalLength", "dam:size", "exif:ImageQuality", "exif:Fired", "exif:WhiteBalance", "exif:AfMode",
            "exif:DriveMode", "exif:PictureStyle" };

    /**
     * The constant REQUIRED_METADATA_FIELDS_SCENE7_IMAGES.
     */
    public static final String[] REQUIRED_METADATA_FIELDS_SCENE7_IMAGES = new String[] { "dc:format", "dam:scene7Domain",
            "dam:scene7File" };

    /**
     * The constant IS_IMAGE.
     */
    public static final String IS_IMAGE = "is/image/";

    /**
     * The constant IS_CONTENT.
     */
    public static final String IS_CONTENT = "is/content/";

    /**
     * The constant HYPHEN.
     */
    public static final String HYPHEN = "-";

    /**
     * The constant CSCENE7_DEFAULT_DATA_SRC.
     */
    public static final String CSCENE7_DEFAULT_DATA_SRC = "data:image/gif;base64,R0lGODlhAQABAIAAAAAAAP///yH5BAEAAAAALAAAAAABAAEAAAIBRAA7";

    /**
     * The constant TEXT_HTML.
     */
    public static final String TEXT_HTML = "text/html";

    /**
     * The constant TEXT_PLAIN.
     */
    public static final String TEXT_PLAIN = "text/plain";

    /**
     * Constant for ACCEPT_EN_US
     */
    public static final String ACCEPT_EN_US = "en-US,en;q=0.5";

    /**
     * Constant for ACCEPT_LANGUAGE
     */
    public static final String ACCEPT_LANGUAGE = "Accept-Language";

    /**
     * Constant for CONTENT_TYPE
     */
    public static final String CONTENT_TYPE = "Content-Type";

    /**
     * Constant for AUTHORIZATION
     */
    public static final String AUTHORIZATION = "Authorization";

    /**
     * Constant for JPEG_RENDITION
     */
    public static final String JPEG_WATERMARK_RENDITION = "cq.dam.wm.jpeg";

    /**
     * Constant for PNG_RENDITION
     */
    public static final String PNG_WATERMARK_RENDITION = "cq.dam.wm.png";

    /**
     * Commerce Integration Framework constant overrides for Canon
     */
    public static final String MAGENTO_GRAPHQL_PROVIDER = "magento-graphql";
    public static final String PRODUCT = "product";
    public static final String VARIANT = "variant";
    public static final String CATEGORY = "category";
    public static final String LEAF_CATEGORY = "isLeaf";
    public static final String SKU = "sku";
    public static final String SLUG = "slug";
    public static final String CIF_ID = "cifId";
    public static final String PRODUCT_FORMATTED_PRICE = "formattedPrice";
    public static final String STORE_HEADER = "Store";
    public static final String MAGENTO_STORE_PROPERTY = "cq:magentoStore";
    public static final String MAGENTO_ROOT_CATEGORY_ID_PROPERTY = "magentoRootCategoryId";

    /**
     * Commerce-related constants
     */
    public static final String CATALOG_BINDING_PATH = "/var/commerce/products/cusa";

    /**
     * Tag strings for use in describing assets
     */
    public static final String TAG_CATEGORY_IMAGE = "canon:asset-types/base-category-image";

    /**
     * The constant URI.
     */
    public static final String URI = "uri";

    /**
     * The constant URL.
     */
    public static final String URL = "url";

    /**
     * The constant for property cq:template.
     */
    public static final String CQ_TEMPLATE = "cq:template";

    /**
     * The constant PATH.
     */
    public static final String PATH = "path";
    /**
     * The constant TYPE.
     */
    public static final String TYPE = "type";
    /**
     * The constant CQ_TAG.
     */
    public static final String CQ_TAG = "cq:Tag";
    /**
     * The constant CONTENT_CQ_TAGS.
     */
    public static final String CONTENT_CQ_TAGS = "/content/cq:tags";
    /**
     * The constant NODENAME.
     */
    public static final String NODENAME = "nodename";

    /**
     * The constant NAME.
     */
    public static final String NAME = "name";

    /**
     * The constant ORDERBY.
     */
    public static final String ORDERBY = "orderby";
    /**
     * The constant P_GUESSTOTAL.
     */
    public static final String P_GUESSTOTAL = "p.guesstotal";
    /**
     * The constant TRUE1.
     */
    public static final String TRUE1 = "true";
    /**
     * The constant TRUE.
     */
    public static final String TRUE = "true";
    /**
     * The constant FALSE.
     */
    public static final String FALSE = "false";
    /**
     * The constant CONTENT_EXPERIENCE_FRAGMENTS.
     */
    public static final String CONTENT_EXPERIENCE_FRAGMENTS = "/content/experience-fragments";
    /**
     * The constant CQ_PAGE.
     */
    public static final String DAM_ASSET = "dam:Asset";
    /**
     * The constant CQ_PAGE.
     */
    public static final String CQ_PAGE = "cq:Page";

    /**
     * The constant NT_UNSTRUCTURED.
     */
    public static final String NT_UNSTRUCTURED = "nt:unstructured";

    /**
     * The constant PROPERTY.
     */
    public static final String PROPERTY = "property";

    /**
     * The constant JCR_CONTENT_METADATA_CONTENT_TYPE.
     */
    public static final String JCR_CONTENT_METADATA_CONTENT_TYPE = "contentType";
    /**
     * The constant JCR_CONTENT_CQ_TAGS.
     */
    public static final String JCR_CONTENT_CQ_TAGS = "jcr:content/cq:tags";
    /**
     * The constant PROPERTY_AND.
     */
    public static final String PROPERTY_AND = "property.and";
    /**
     * The constant PROPERTY_1_VALUE.
     */
    public static final String PROPERTY_VALUE = "property.value";
    /**
     * The constant PROPERTY_1_VALUE.
     */
    public static final String PROPERTY_1_VALUE = "property.1_value";
    /**
     * The constant PROPERTY_2_VALUE.
     */
    public static final String PROPERTY_2_VALUE = "property.2_value";
    /**
     * The constant P_OFFSET.
     */
    public static final String P_OFFSET = "p.offset";
    /**
     * The constant ZERO.
     */
    public static final String ZERO = "0";
    /**
     * The constant P_LIMIT.
     */
    public static final String P_LIMIT = "p.limit";
    /**
     * The constant HTML.
     */
    public static final String HTML = ".html";

    /**
     * The constant PLAIN_HTML.
     */
    public static final String PLAIN_HTML = ".plain.html";

    public static final String NO_JS_LOAD = "noJSLoad";

    public static final String NO_CSS_LOAD = "noCSSLoad";

    public static final String SELECTOR_SEPARATOR = ".";


    /**
     * The constant FORWARD_SLASH.
     */
    public static final char FORWARD_SLASH = '/';

    public static final String COMMA = ",";

    public static final String SPACE = " ";

    public static final String CONTENT_EXPERIENCE_FRAGMENTS_CANON_GLOBAL_HEADER_MASTER_JCR_CONTENT_ROOT_HEADER = "/content/experience-fragments/canon/global/header/master/jcr:content/root/header";

    /**
     * The constant X_ORGANIZATION_ID.
     */
    public static final String X_ORGANIZATION_ID = "x-organization-id";

    /**
     * The constant SYSTEM_NAME
     */
    public static final String SYSTEM_NAME = "system-name";

    /**
     * The constant USER_DOCUMENT_TYPE
     */
    public static final String USER_DOCUMENT_TYPE = "user-document-type";

    /**
     * The constant CUSA.
     */
    public static final String CUSA = "CUSA";

    /**
     * The constant for Basic authentication header.
     */
    public static final String BASIC_AUTHORIZATION = "Basic ";

    /**
     * The constant for Question Mark
     */
    public static final String QUESTION_MARK = "?";

    /**
     * The constant for Ampersand Sign
     */
    public static final String AMPERSAND_SIGN = "&";

    /**
     * The constant for Equals Sign
     */
    public static final String EQUALS_SIGN = "=";

    /**
     * The constant for Colon Sign
     */
    public static final String COLON_SIGN = ":";


    public static final String USER_ID = "USER-ID";

    public static final String BEARER = "Bearer ";

    /**
     * The constant ISS.
     */
    public static final String ISS = "iss";
    /**
     * The constant SOURCE.
     */
    public static final String SOURCE = "source";
    /**
     * The constant EXP.
     */
    public static final String EXP = "exp";
    /**
     * The constant ALG.
     */
    public static final String ALG = "alg";
    /**
     * The constant TYP.
     */
    public static final String TYP = "typ";
    /**
     * The constant RS_256.
     */
    public static final String RS_256 = "RS256";


    /**
     * The constant JWT.
     */
    public static final String JWT = "JWT";

    /**
     * The constant RSA.
     */
    public static final String RSA = "RSA";
    /**
     * The constant uuid.
     */
    public static final String UUID = "uuid";

    /**
     * The constant GUID.
     */
    public static final String GUID = "guid";

    /**
     * The constant for Plus Sign
     */
    public static final String PLUS_SIGN = "+";

    /**
     * The constant for dot symbol
     */
    public static final String DOT_SYMBOL = ".";

    /**
     * The constant for BOOL_PROPERTY_PREDICATE query builder predicate
     */
    public static final String BOOL_PROPERTY_PREDICATE = "boolproperty";

    /**
     * The constant for VALUE
     */
    public static final String VALUE = "value";

    /**
     * The constant for GROUP
     */
    public static final String GROUP = "group";

    /**
     * The constant for OR logical operator
     */
    public static final String OR = "or";
}
