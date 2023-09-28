package com.hwan.ecoandrichtest.domain.dto;


import lombok.Data;

import java.util.List;

@Data
public class ApiResponse {
    private Header header;
    private Body body;

    @Data
    public static class Header {
        private String resultCode;
        private String resultMsg;
    }

    @Data
    public static class Body {
        private Item items;
        private String totalCount;
    }

    @Data
    public static class Item {
        private String hsptlKnd;
        private String hsptlNm;
        private String roomSo;
        private String patntCo;
        private String fondSe;
        private String estblde;
        private String locplc;
        private String telno;
        private String fxnum;
    }
}
