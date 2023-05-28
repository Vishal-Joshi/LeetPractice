package my.practice.ctci;

import my.practice.ctci.models.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Vishal Joshi
 */
class PathsWithSumTest {

    @Test
    void testShouldFindCorrectNumberOfPathsWithSum(){
        //given
        TreeNode leaf3= new TreeNode(3);
        TreeNode leafMinus2= new TreeNode(-2);
        TreeNode node3= new TreeNode(3, leaf3, leafMinus2);

        TreeNode leaf2= new TreeNode(2);
        TreeNode node1= new TreeNode(1, null, leaf2);

        TreeNode node5= new TreeNode(5, node3, node1);

        TreeNode leaf11 = new TreeNode(11);
        TreeNode nodeMinus3 = new TreeNode(-3, null, leaf11);

        TreeNode root = new TreeNode(10, node5, nodeMinus3);

        PathsWithSum pathsWithSum = new PathsWithSum();

        //when
        int totalPaths = pathsWithSum.countPathsWithSum(root, 8);

        //then
        assertEquals(3, totalPaths);
    }

}