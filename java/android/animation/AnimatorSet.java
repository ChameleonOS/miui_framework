// Decompiled by Jad v1.5.8e. Copyright 2001 Pavel Kouznetsov.
// Jad home page: http://www.geocities.com/kpdus/jad.html
// Decompiler options: packimports(3) nonlb 

package android.animation;

import java.util.*;

// Referenced classes of package android.animation:
//            Animator, ValueAnimator, ObjectAnimator, TimeInterpolator, 
//            AnimatorListenerAdapter

public final class AnimatorSet extends Animator {
    public class Builder {

        public Builder after(long l) {
            float af[] = new float[2];
            af[0] = 0.0F;
            af[1] = 1.0F;
            ValueAnimator valueanimator = ValueAnimator.ofFloat(af);
            valueanimator.setDuration(l);
            after(((Animator) (valueanimator)));
            return this;
        }

        public Builder after(Animator animator) {
            Node node = (Node)mNodeMap.get(animator);
            if(node == null) {
                node = new Node(animator);
                mNodeMap.put(animator, node);
                mNodes.add(node);
            }
            Dependency dependency = new Dependency(node, 1);
            mCurrentNode.addDependency(dependency);
            return this;
        }

        public Builder before(Animator animator) {
            Node node = (Node)mNodeMap.get(animator);
            if(node == null) {
                node = new Node(animator);
                mNodeMap.put(animator, node);
                mNodes.add(node);
            }
            node.addDependency(new Dependency(mCurrentNode, 1));
            return this;
        }

        public Builder with(Animator animator) {
            Node node = (Node)mNodeMap.get(animator);
            if(node == null) {
                node = new Node(animator);
                mNodeMap.put(animator, node);
                mNodes.add(node);
            }
            node.addDependency(new Dependency(mCurrentNode, 0));
            return this;
        }

        private Node mCurrentNode;
        final AnimatorSet this$0;

        Builder(Animator animator) {
            this$0 = AnimatorSet.this;
            super();
            mCurrentNode = (Node)mNodeMap.get(animator);
            if(mCurrentNode == null) {
                mCurrentNode = new Node(animator);
                mNodeMap.put(animator, mCurrentNode);
                mNodes.add(mCurrentNode);
            }
        }
    }

    private static class Node
        implements Cloneable {

        public void addDependency(Dependency dependency) {
            if(dependencies == null) {
                dependencies = new ArrayList();
                nodeDependencies = new ArrayList();
            }
            dependencies.add(dependency);
            if(!nodeDependencies.contains(dependency.node))
                nodeDependencies.add(dependency.node);
            Node node = dependency.node;
            if(node.nodeDependents == null)
                node.nodeDependents = new ArrayList();
            node.nodeDependents.add(this);
        }

        public Node clone() {
            Node node;
            try {
                node = (Node)super.clone();
                node.animation = animation.clone();
            }
            catch(CloneNotSupportedException clonenotsupportedexception) {
                throw new AssertionError();
            }
            return node;
        }

        public volatile Object clone() throws CloneNotSupportedException {
            return clone();
        }

        public Animator animation;
        public ArrayList dependencies;
        public boolean done;
        public ArrayList nodeDependencies;
        public ArrayList nodeDependents;
        public ArrayList tmpDependencies;

        public Node(Animator animator) {
            dependencies = null;
            tmpDependencies = null;
            nodeDependencies = null;
            nodeDependents = null;
            done = false;
            animation = animator;
        }
    }

    private static class Dependency {

        static final int AFTER = 1;
        static final int WITH;
        public Node node;
        public int rule;

        public Dependency(Node node1, int i) {
            node = node1;
            rule = i;
        }
    }

    private class AnimatorSetListener
        implements Animator.AnimatorListener {

        public void onAnimationCancel(Animator animator) {
            if(!mTerminated && mPlayingSet.size() == 0 && mListeners != null) {
                int i = mListeners.size();
                for(int j = 0; j < i; j++)
                    ((Animator.AnimatorListener)mListeners.get(j)).onAnimationCancel(mAnimatorSet);

            }
        }

        public void onAnimationEnd(Animator animator) {
label0:
            {
                animator.removeListener(this);
                mPlayingSet.remove(animator);
                ((Node)mAnimatorSet.mNodeMap.get(animator)).done = true;
                if(mTerminated)
                    break label0;
                ArrayList arraylist = mAnimatorSet.mSortedNodes;
                boolean flag = true;
                int i = arraylist.size();
                int j = 0;
label1:
                do {
label2:
                    {
                        if(j < i) {
                            if(((Node)arraylist.get(j)).done)
                                break label2;
                            flag = false;
                        }
                        if(!flag)
                            break label0;
                        if(mListeners != null) {
                            ArrayList arraylist1 = (ArrayList)mListeners.clone();
                            int k = arraylist1.size();
                            for(int l = 0; l < k; l++)
                                ((Animator.AnimatorListener)arraylist1.get(l)).onAnimationEnd(mAnimatorSet);

                        }
                        break label1;
                    }
                    j++;
                } while(true);
                mAnimatorSet.mStarted = false;
            }
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
        }

        private AnimatorSet mAnimatorSet;
        final AnimatorSet this$0;

        AnimatorSetListener(AnimatorSet animatorset1) {
            this$0 = AnimatorSet.this;
            super();
            mAnimatorSet = animatorset1;
        }
    }

    private static class DependencyListener
        implements Animator.AnimatorListener {

        private void startIfReady(Animator animator) {
            if(!mAnimatorSet.mTerminated) goto _L2; else goto _L1
_L1:
            return;
_L2:
            Dependency dependency = null;
            int i = mNode.tmpDependencies.size();
            int j = 0;
            do {
label0:
                {
                    if(j < i) {
                        Dependency dependency1 = (Dependency)mNode.tmpDependencies.get(j);
                        if(dependency1.rule != mRule || dependency1.node.animation != animator)
                            break label0;
                        dependency = dependency1;
                        animator.removeListener(this);
                    }
                    mNode.tmpDependencies.remove(dependency);
                    if(mNode.tmpDependencies.size() == 0) {
                        mNode.animation.start();
                        mAnimatorSet.mPlayingSet.add(mNode.animation);
                    }
                }
                if(true)
                    continue;
                j++;
            } while(true);
            if(true) goto _L1; else goto _L3
_L3:
        }

        public void onAnimationCancel(Animator animator) {
        }

        public void onAnimationEnd(Animator animator) {
            if(mRule == 1)
                startIfReady(animator);
        }

        public void onAnimationRepeat(Animator animator) {
        }

        public void onAnimationStart(Animator animator) {
            if(mRule == 0)
                startIfReady(animator);
        }

        private AnimatorSet mAnimatorSet;
        private Node mNode;
        private int mRule;

        public DependencyListener(AnimatorSet animatorset, Node node, int i) {
            mAnimatorSet = animatorset;
            mNode = node;
            mRule = i;
        }
    }


    public AnimatorSet() {
        mPlayingSet = new ArrayList();
        mNodeMap = new HashMap();
        mNodes = new ArrayList();
        mSortedNodes = new ArrayList();
        mNeedsSort = true;
        mSetListener = null;
        mTerminated = false;
        mStarted = false;
        mStartDelay = 0L;
        mDelayAnim = null;
        mDuration = -1L;
    }

    private void sortNodes() {
        if(mNeedsSort) {
            mSortedNodes.clear();
            ArrayList arraylist = new ArrayList();
            int i1 = mNodes.size();
            for(int j1 = 0; j1 < i1; j1++) {
                Node node3 = (Node)mNodes.get(j1);
                if(node3.dependencies == null || node3.dependencies.size() == 0)
                    arraylist.add(node3);
            }

            ArrayList arraylist1 = new ArrayList();
            for(; arraylist.size() > 0; arraylist1.clear()) {
                int k1 = arraylist.size();
                for(int l1 = 0; l1 < k1; l1++) {
                    Node node1 = (Node)arraylist.get(l1);
                    mSortedNodes.add(node1);
                    if(node1.nodeDependents == null)
                        continue;
                    int i2 = node1.nodeDependents.size();
                    for(int j2 = 0; j2 < i2; j2++) {
                        Node node2 = (Node)node1.nodeDependents.get(j2);
                        node2.nodeDependencies.remove(node1);
                        if(node2.nodeDependencies.size() == 0)
                            arraylist1.add(node2);
                    }

                }

                arraylist.clear();
                arraylist.addAll(arraylist1);
            }

            mNeedsSort = false;
            if(mSortedNodes.size() != mNodes.size())
                throw new IllegalStateException("Circular dependencies cannot exist in AnimatorSet");
        } else {
            int i = mNodes.size();
            for(int j = 0; j < i; j++) {
                Node node = (Node)mNodes.get(j);
                if(node.dependencies != null && node.dependencies.size() > 0) {
                    int k = node.dependencies.size();
                    for(int l = 0; l < k; l++) {
                        Dependency dependency = (Dependency)node.dependencies.get(l);
                        if(node.nodeDependencies == null)
                            node.nodeDependencies = new ArrayList();
                        if(!node.nodeDependencies.contains(dependency.node))
                            node.nodeDependencies.add(dependency.node);
                    }

                }
                node.done = false;
            }

        }
    }

    public void cancel() {
        ArrayList arraylist;
        mTerminated = true;
        if(!isStarted())
            break MISSING_BLOCK_LABEL_177;
        arraylist = null;
        if(super.mListeners != null) {
            arraylist = (ArrayList)super.mListeners.clone();
            for(Iterator iterator2 = arraylist.iterator(); iterator2.hasNext(); ((Animator.AnimatorListener)iterator2.next()).onAnimationCancel(this));
        }
        if(mDelayAnim == null || !mDelayAnim.isRunning()) goto _L2; else goto _L1
_L1:
        mDelayAnim.cancel();
_L4:
        if(arraylist != null) {
            for(Iterator iterator1 = arraylist.iterator(); iterator1.hasNext(); ((Animator.AnimatorListener)iterator1.next()).onAnimationEnd(this));
        }
        break; /* Loop/switch isn't completed */
_L2:
        if(mSortedNodes.size() > 0) {
            Iterator iterator = mSortedNodes.iterator();
            while(iterator.hasNext()) 
                ((Node)iterator.next()).animation.cancel();
        }
        if(true) goto _L4; else goto _L3
_L3:
        mStarted = false;
    }

    public volatile Animator clone() {
        return clone();
    }

    public AnimatorSet clone() {
        AnimatorSet animatorset = (AnimatorSet)super.clone();
        animatorset.mNeedsSort = true;
        animatorset.mTerminated = false;
        animatorset.mStarted = false;
        animatorset.mPlayingSet = new ArrayList();
        animatorset.mNodeMap = new HashMap();
        animatorset.mNodes = new ArrayList();
        animatorset.mSortedNodes = new ArrayList();
        HashMap hashmap = new HashMap();
        Iterator iterator = mNodes.iterator();
        do {
            if(!iterator.hasNext())
                break;
            Node node2 = (Node)iterator.next();
            Node node3 = node2.clone();
            hashmap.put(node2, node3);
            animatorset.mNodes.add(node3);
            animatorset.mNodeMap.put(node3.animation, node3);
            node3.dependencies = null;
            node3.tmpDependencies = null;
            node3.nodeDependents = null;
            node3.nodeDependencies = null;
            ArrayList arraylist = node3.animation.getListeners();
            if(arraylist != null) {
                ArrayList arraylist1 = null;
                Iterator iterator3 = arraylist.iterator();
                do {
                    if(!iterator3.hasNext())
                        break;
                    Animator.AnimatorListener animatorlistener = (Animator.AnimatorListener)iterator3.next();
                    if(animatorlistener instanceof AnimatorSetListener) {
                        if(arraylist1 == null)
                            arraylist1 = new ArrayList();
                        arraylist1.add(animatorlistener);
                    }
                } while(true);
                if(arraylist1 != null) {
                    Iterator iterator4 = arraylist1.iterator();
                    while(iterator4.hasNext()) 
                        arraylist.remove((Animator.AnimatorListener)iterator4.next());
                }
            }
        } while(true);
        Iterator iterator1 = mNodes.iterator();
        do {
            if(!iterator1.hasNext())
                break;
            Node node = (Node)iterator1.next();
            Node node1 = (Node)hashmap.get(node);
            if(node.dependencies != null) {
                Iterator iterator2 = node.dependencies.iterator();
                while(iterator2.hasNext())  {
                    Dependency dependency = (Dependency)iterator2.next();
                    node1.addDependency(new Dependency((Node)hashmap.get(dependency.node), dependency.rule));
                }
            }
        } while(true);
        return animatorset;
    }

    public volatile Object clone() throws CloneNotSupportedException {
        return clone();
    }

    public void end() {
        mTerminated = true;
        if(isStarted()) {
            if(mSortedNodes.size() != mNodes.size()) {
                sortNodes();
                Node node;
                for(Iterator iterator2 = mSortedNodes.iterator(); iterator2.hasNext(); node.animation.addListener(mSetListener)) {
                    node = (Node)iterator2.next();
                    if(mSetListener == null)
                        mSetListener = new AnimatorSetListener(this);
                }

            }
            if(mDelayAnim != null)
                mDelayAnim.cancel();
            if(mSortedNodes.size() > 0) {
                for(Iterator iterator1 = mSortedNodes.iterator(); iterator1.hasNext(); ((Node)iterator1.next()).animation.end());
            }
            if(super.mListeners != null) {
                for(Iterator iterator = ((ArrayList)super.mListeners.clone()).iterator(); iterator.hasNext(); ((Animator.AnimatorListener)iterator.next()).onAnimationEnd(this));
            }
            mStarted = false;
        }
    }

    public ArrayList getChildAnimations() {
        ArrayList arraylist = new ArrayList();
        for(Iterator iterator = mNodes.iterator(); iterator.hasNext(); arraylist.add(((Node)iterator.next()).animation));
        return arraylist;
    }

    public long getDuration() {
        return mDuration;
    }

    public long getStartDelay() {
        return mStartDelay;
    }

    public boolean isRunning() {
        Iterator iterator = mNodes.iterator();
_L4:
        if(!iterator.hasNext()) goto _L2; else goto _L1
_L1:
        if(!((Node)iterator.next()).animation.isRunning()) goto _L4; else goto _L3
_L3:
        boolean flag = true;
_L6:
        return flag;
_L2:
        flag = false;
        if(true) goto _L6; else goto _L5
_L5:
    }

    public boolean isStarted() {
        return mStarted;
    }

    public Builder play(Animator animator) {
        Builder builder;
        if(animator != null) {
            mNeedsSort = true;
            builder = new Builder(animator);
        } else {
            builder = null;
        }
        return builder;
    }

    public void playSequentially(List list) {
        if(list != null && list.size() > 0) {
            mNeedsSort = true;
            if(list.size() == 1) {
                play((Animator)list.get(0));
            } else {
                int i = 0;
                while(i < -1 + list.size())  {
                    play((Animator)list.get(i)).before((Animator)list.get(i + 1));
                    i++;
                }
            }
        }
    }

    public transient void playSequentially(Animator aanimator[]) {
        if(aanimator != null) {
            mNeedsSort = true;
            if(aanimator.length == 1) {
                play(aanimator[0]);
            } else {
                int i = 0;
                while(i < -1 + aanimator.length)  {
                    play(aanimator[i]).before(aanimator[i + 1]);
                    i++;
                }
            }
        }
    }

    public void playTogether(Collection collection) {
        if(collection != null && collection.size() > 0) {
            mNeedsSort = true;
            Builder builder = null;
            for(Iterator iterator = collection.iterator(); iterator.hasNext();) {
                Animator animator = (Animator)iterator.next();
                if(builder == null)
                    builder = play(animator);
                else
                    builder.with(animator);
            }

        }
    }

    public transient void playTogether(Animator aanimator[]) {
        if(aanimator != null) {
            mNeedsSort = true;
            Builder builder = play(aanimator[0]);
            for(int i = 1; i < aanimator.length; i++)
                builder.with(aanimator[i]);

        }
    }

    public volatile Animator setDuration(long l) {
        return setDuration(l);
    }

    public AnimatorSet setDuration(long l) {
        if(l < 0L) {
            throw new IllegalArgumentException("duration must be a value of zero or greater");
        } else {
            mDuration = l;
            return this;
        }
    }

    public void setInterpolator(TimeInterpolator timeinterpolator) {
        for(Iterator iterator = mNodes.iterator(); iterator.hasNext(); ((Node)iterator.next()).animation.setInterpolator(timeinterpolator));
    }

    public void setStartDelay(long l) {
        mStartDelay = l;
    }

    public void setTarget(Object obj) {
        Iterator iterator = mNodes.iterator();
        do {
            if(!iterator.hasNext())
                break;
            Animator animator = ((Node)iterator.next()).animation;
            if(animator instanceof AnimatorSet)
                ((AnimatorSet)animator).setTarget(obj);
            else
            if(animator instanceof ObjectAnimator)
                ((ObjectAnimator)animator).setTarget(obj);
        } while(true);
    }

    public void setupEndValues() {
        for(Iterator iterator = mNodes.iterator(); iterator.hasNext(); ((Node)iterator.next()).animation.setupEndValues());
    }

    public void setupStartValues() {
        for(Iterator iterator = mNodes.iterator(); iterator.hasNext(); ((Node)iterator.next()).animation.setupStartValues());
    }

    public void start() {
        mTerminated = false;
        mStarted = true;
        if(mDuration >= 0L) {
            for(Iterator iterator2 = mNodes.iterator(); iterator2.hasNext(); ((Node)iterator2.next()).animation.setDuration(mDuration));
        }
        sortNodes();
        int i = mSortedNodes.size();
label0:
        for(int j = 0; j < i; j++) {
            Node node2 = (Node)mSortedNodes.get(j);
            ArrayList arraylist2 = node2.animation.getListeners();
            if(arraylist2 == null || arraylist2.size() <= 0)
                continue;
            Iterator iterator1 = (new ArrayList(arraylist2)).iterator();
            do {
                Animator.AnimatorListener animatorlistener;
                do {
                    if(!iterator1.hasNext())
                        continue label0;
                    animatorlistener = (Animator.AnimatorListener)iterator1.next();
                } while(!(animatorlistener instanceof DependencyListener) && !(animatorlistener instanceof AnimatorSetListener));
                node2.animation.removeListener(animatorlistener);
            } while(true);
        }

        final ArrayList nodesToStart = new ArrayList();
        int k = 0;
        while(k < i)  {
            Node node1 = (Node)mSortedNodes.get(k);
            if(mSetListener == null) {
                AnimatorSetListener animatorsetlistener = new AnimatorSetListener(this);
                mSetListener = animatorsetlistener;
            }
            if(node1.dependencies == null || node1.dependencies.size() == 0) {
                nodesToStart.add(node1);
            } else {
                int l1 = node1.dependencies.size();
                for(int i2 = 0; i2 < l1; i2++) {
                    Dependency dependency = (Dependency)node1.dependencies.get(i2);
                    Animator animator = dependency.node.animation;
                    DependencyListener dependencylistener = new DependencyListener(this, node1, dependency.rule);
                    animator.addListener(dependencylistener);
                }

                node1.tmpDependencies = (ArrayList)node1.dependencies.clone();
            }
            node1.animation.addListener(mSetListener);
            k++;
        }
        if(mStartDelay <= 0L) {
            Node node;
            for(Iterator iterator = nodesToStart.iterator(); iterator.hasNext(); mPlayingSet.add(node.animation)) {
                node = (Node)iterator.next();
                node.animation.start();
            }

        } else {
            float af[] = new float[2];
            af[0] = 0.0F;
            af[1] = 1.0F;
            mDelayAnim = ValueAnimator.ofFloat(af);
            mDelayAnim.setDuration(mStartDelay);
            ValueAnimator valueanimator = mDelayAnim;
            AnimatorListenerAdapter animatorlisteneradapter = new AnimatorListenerAdapter() {

                public void onAnimationCancel(Animator animator1) {
                    canceled = true;
                }

                public void onAnimationEnd(Animator animator1) {
                    if(!canceled) {
                        int j2 = nodesToStart.size();
                        for(int k2 = 0; k2 < j2; k2++) {
                            Node node3 = (Node)nodesToStart.get(k2);
                            node3.animation.start();
                            mPlayingSet.add(node3.animation);
                        }

                    }
                }

                boolean canceled;
                final AnimatorSet this$0;
                final ArrayList val$nodesToStart;

             {
                this$0 = AnimatorSet.this;
                nodesToStart = arraylist;
                super();
                canceled = false;
            }
            };
            valueanimator.addListener(animatorlisteneradapter);
            mDelayAnim.start();
        }
        if(super.mListeners != null) {
            ArrayList arraylist1 = (ArrayList)super.mListeners.clone();
            int j1 = arraylist1.size();
            for(int k1 = 0; k1 < j1; k1++)
                ((Animator.AnimatorListener)arraylist1.get(k1)).onAnimationStart(this);

        }
        if(mNodes.size() == 0 && mStartDelay == 0L) {
            mStarted = false;
            if(super.mListeners != null) {
                ArrayList arraylist = (ArrayList)super.mListeners.clone();
                int l = arraylist.size();
                for(int i1 = 0; i1 < l; i1++)
                    ((Animator.AnimatorListener)arraylist.get(i1)).onAnimationEnd(this);

            }
        }
    }

    private ValueAnimator mDelayAnim;
    private long mDuration;
    private boolean mNeedsSort;
    private HashMap mNodeMap;
    private ArrayList mNodes;
    private ArrayList mPlayingSet;
    private AnimatorSetListener mSetListener;
    private ArrayList mSortedNodes;
    private long mStartDelay;
    private boolean mStarted;
    boolean mTerminated;





/*
    static boolean access$302(AnimatorSet animatorset, boolean flag) {
        animatorset.mStarted = flag;
        return flag;
    }

*/

}
