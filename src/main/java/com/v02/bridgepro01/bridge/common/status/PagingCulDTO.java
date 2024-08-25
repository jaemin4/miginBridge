package com.v02.bridgepro01.bridge.common.status;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class PagingCulDTO {
    private int requestPage;
    private int pazeSize;

    public int getOffset() {
        return (requestPage-1) * pazeSize;
    }

    public int getMaxPage(int totalPage){
        return totalPage/pazeSize;
    }





}
