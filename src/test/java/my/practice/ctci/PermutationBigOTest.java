package my.practice.ctci;

import org.junit.jupiter.api.Test;

/**
 * @author Vishal Joshi
 */
class PermutationBigOTest {

    @Test
    void testShouldVerifyPermutationsArePrintedAsExpected(){
        //given
        PermutationBigO permutationBigO = new PermutationBigO();

        //when
        permutationBigO.permutation("abcd");

    }
}