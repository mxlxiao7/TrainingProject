package leon.training.designpattern.create.factory.simple;

import android.support.v4.app.Fragment;
import android.text.TextUtils;

import leon.training.algorithm.SortBubble;
import leon.training.algorithm.SortHeap;
import leon.training.algorithm.SortInsertion;
import leon.training.algorithm.SortMergeNonRecursive;
import leon.training.algorithm.SortMergeRecursive;
import leon.training.algorithm.SortQuick;
import leon.training.algorithm.SortSelection;
import leon.training.algorithm.SortShell;
import leon.training.algorithm.sortfragment.SortFragment;
import leon.training.function.broadcast.BroadCastFragment;
import leon.training.databinding.DataBindingFragment;
import leon.training.designpattern.behavior.templatemethod.TemplateMethodFragment;
import leon.training.designpattern.structure.adapter.AdapterFragment;
import leon.training.designpattern.structure.bridge.BridgeFragment;
import leon.training.designpattern.create.builder.BuilderFragment;
import leon.training.designpattern.behavior.chain.ChainFragment;
import leon.training.designpattern.structure.component.ComponentFragment;
import leon.training.designpattern.structure.decorator.DecoratorFragment;
import leon.training.designpattern.structure.facade.FacadeFragment;
import leon.training.designpattern.create.factory.abs.AbstractFactoryFragment;
import leon.training.designpattern.create.factory.method.MethodFactoryFragment;
import leon.training.designpattern.structure.proxy.ProxyFragment;
import leon.training.designpattern.structure.proxy.dynamic.DynamicProxyFragment;
import leon.training.function.init.StaticInitIndexFragment;
import leon.training.function.multipleextends.MultipleExtendsFragment;
import leon.training.function.volatiletest.VolatileFragment;
import leon.training.function.groovy.GroovyFragment;
import leon.training.function.lambda.LambdaFragment;
import leon.training.function.launchmode.LaunchModeFragment;
import leon.training.function.leaks.LeakFragment;
import leon.training.function.memory.MemoryFragment;
import leon.training.function.network.NetworkFragment;
import leon.training.function.rx.RxFragment;
import leon.training.datastructure.StructureFragment;
import leon.training.ndk.NDKFragment;
import leon.training.ndk.splistmerge.SplitsMergeFragment;
import leon.training.thread.ThreadFragment;
import leon.training.function.trycatch.TryCatchFragment;
import leon.training.function.view.ViewFragment;
import leon.training.thread.multithread.MultiThreadFragment;

/**
 * Created by maxiaolong on 2017/4/19.
 */

public class FragmentFactory {

    public static final String[] TITLES = new String[]{
            "Sort-Selection",
            "Sort-Insertion",
            "Sort-Shell",
            "Sort-Bubble",
            "Sort-MergeRecursive",
            "Sort-MergeNonRecursive",
            "Sort-SortHeap",
            "Sort-SortQuick",
            "Groovy",
            "Thread",
            "MultiThread",
            "Rx",
            "Lambda",
            "Decorator",
            "Data Structure",
            "Try Catch Condition",
            "DP-MethodFactory",
            "DP-AbstractFactory ",
            "DP-Builder",
            "DP-Adapter",
            "DP-Decorator",
            "DP-Proxy",
            "DP-Dynamic_Proxy",
            "DP-Facade",
            "DP-Bridge",
            "DP-Component",
            "DP-Chain",
            "DP-TemplateMethod",
            "View-Step",
            "View-DataBinding",
            "Net-Okhttp",
            "Fun-Leaks",
            "Launch-Mode",
            "Broad-Cast",
            "Fun-Memory",
            "Fun-StaticInitIndex",
            "Fun-MultipleExtends",
            "Fun-Volatile",
            "Fun-NDK",
            "FUN-NDK-SPLIT-MERGE"
    };


    /**
     * 根据名称创建 Fragment
     *
     * @return
     */
    public static Fragment createFragment(String key) {
        if (TextUtils.isEmpty(key)) {
            return null;
        }
        Fragment f = null;
        switch (key) {
            case "Sort-Selection":
                f = SortFragment.newInstance(new SortSelection());
                break;
            case "Sort-Insertion":
                f = SortFragment.newInstance(new SortInsertion());
                break;
            case "Sort-Shell":
                f = SortFragment.newInstance(new SortShell());
                break;
            case "Sort-Bubble":
                f = SortFragment.newInstance(new SortBubble());
                break;
            case "Sort-MergeRecursive":
                f = SortFragment.newInstance(new SortMergeRecursive());
                break;
            case "Sort-MergeNonRecursive":
                f = SortFragment.newInstance(new SortMergeNonRecursive());
                break;
            case "Sort-SortHeap":
                f = SortFragment.newInstance(new SortHeap());
                break;
            case "Sort-SortQuick":
                f = SortFragment.newInstance(new SortQuick());
                break;
            case "Groovy":
                f = GroovyFragment.newInstance();
                break;
            case "Thread":
                f = ThreadFragment.newInstance();
                break;
            case "MultiThread":
                f = MultiThreadFragment.newInstance();
                break;
            case "Rx":
                f = RxFragment.newInstance();
                break;
            case "Lambda":
                f = LambdaFragment.newInstance();
                break;
            case "Decorator":
                f = DecoratorFragment.newInstance();
                break;
            case "Data Structure":
                f = StructureFragment.newInstance();
                break;
            case "Try Catch Condition":
                f = TryCatchFragment.newInstance();
                break;
            case "DP-AbstractFactory ":
                f = AbstractFactoryFragment.newInstance();
                break;
            case "DP-MethodFactory ":
                f = MethodFactoryFragment.newInstance();
                break;
            case "DP-Builder":
                f = BuilderFragment.newInstance();
                break;
            case "DP-Adapter":
                f = AdapterFragment.newInstance();
                break;
            case "DP-Decorator":
                f = DecoratorFragment.newInstance();
                break;
            case "DP-Proxy":
                f = ProxyFragment.newInstance();
                break;
            case "DP-Facade":
                f = FacadeFragment.newInstance();
                break;
            case "DP-Bridge":
                f = BridgeFragment.newInstance();
                break;
            case "DP-Component":
                f = ComponentFragment.newInstance();
                break;
            case "View-Step":
                f = ViewFragment.newInstance();
                break;
            case "View-DataBinding":
                f = DataBindingFragment.newInstance();
                break;
            case "Net-Okhttp":
                f = NetworkFragment.newInstance();
                break;
            case "DP-Chain":
                f = ChainFragment.newInstance();
                break;
            case "Fun-Leaks":
                f = LeakFragment.newInstance();
                break;
            case "Launch-Mode":
                f = LaunchModeFragment.newInstance();
                break;
            case "Broad-Cast":
                f = BroadCastFragment.newInstance();
                break;
            case "Fun-Memory":
                f = MemoryFragment.newInstance();
                break;
            case "DP-Dynamic_Proxy":
                f = DynamicProxyFragment.newInstance();
                break;
            case "DP-TemplateMethod":
                f = TemplateMethodFragment.newInstance();
                break;
            case "Fun-StaticInitIndex":
                f = StaticInitIndexFragment.newInstance();
                break;
            case "Fun-MultipleExtends":
                f = MultipleExtendsFragment.newInstance();
                break;
            case "Fun-Volatile":
                f = VolatileFragment.newInstance();
                break;
            case "Fun-NDK":
                f = NDKFragment.newInstance();
                break;
            case "FUN-NDK-SPLIT-MERGE":
                f = SplitsMergeFragment.newInstance();
                break;
            default:
                break;
        }
        return f;
    }

}
