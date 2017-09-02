package android.support.v4.app;

import android.graphics.Rect;
import android.transition.Transition;
import android.transition.Transition.EpicenterCallback;
import android.transition.TransitionManager;
import android.transition.TransitionSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.ViewTreeObserver.OnPreDrawListener;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

class FragmentTransitionCompat21
{
  public static void addTargets(Object paramObject, ArrayList<View> paramArrayList)
  {
    paramObject = (Transition)paramObject;
    int j;
    int i;
    if ((paramObject instanceof TransitionSet))
    {
      paramObject = (TransitionSet)paramObject;
      j = ((TransitionSet)paramObject).getTransitionCount();
      i = 0;
      while (i < j)
      {
        addTargets(((TransitionSet)paramObject).getTransitionAt(i), paramArrayList);
        i += 1;
      }
    }
    if ((!hasSimpleTarget((Transition)paramObject)) && (isNullOrEmpty(((Transition)paramObject).getTargets())))
    {
      j = paramArrayList.size();
      i = 0;
      while (i < j)
      {
        ((Transition)paramObject).addTarget((View)paramArrayList.get(i));
        i += 1;
      }
    }
  }
  
  public static void addTransitionTargets(Object paramObject1, Object paramObject2, final Object paramObject3, View paramView1, final ViewRetriever paramViewRetriever, final View paramView2, EpicenterView paramEpicenterView, final Map<String, String> paramMap, final ArrayList<View> paramArrayList1, ArrayList<View> paramArrayList2, Map<String, View> paramMap1, final Map<String, View> paramMap2, ArrayList<View> paramArrayList3)
  {
    final Transition localTransition1 = (Transition)paramObject1;
    paramObject3 = (Transition)paramObject3;
    Transition localTransition2 = (Transition)paramObject2;
    excludeViews(localTransition1, (Transition)paramObject3, paramArrayList2, true);
    if ((paramObject1 != null) || (paramObject2 != null))
    {
      if (localTransition1 != null) {
        localTransition1.addTarget(paramView2);
      }
      if (paramObject2 != null)
      {
        setSharedElementTargets(localTransition2, paramView2, paramMap1, paramArrayList3);
        excludeViews(localTransition1, localTransition2, paramArrayList3, true);
        excludeViews((Transition)paramObject3, localTransition2, paramArrayList3, true);
      }
      paramView1.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public boolean onPreDraw()
        {
          this.val$container.getViewTreeObserver().removeOnPreDrawListener(this);
          if (localTransition1 != null) {
            localTransition1.removeTarget(paramView2);
          }
          if (paramViewRetriever != null)
          {
            View localView = paramViewRetriever.getView();
            if (localView != null)
            {
              if (!paramMap.isEmpty())
              {
                FragmentTransitionCompat21.findNamedViews(paramMap2, localView);
                paramMap2.keySet().retainAll(paramMap.values());
                Iterator localIterator = paramMap.entrySet().iterator();
                while (localIterator.hasNext())
                {
                  Map.Entry localEntry = (Map.Entry)localIterator.next();
                  Object localObject = (String)localEntry.getValue();
                  localObject = (View)paramMap2.get(localObject);
                  if (localObject != null) {
                    ((View)localObject).setTransitionName((String)localEntry.getKey());
                  }
                }
              }
              if (localTransition1 != null)
              {
                FragmentTransitionCompat21.captureTransitioningViews(paramArrayList1, localView);
                paramArrayList1.removeAll(paramMap2.values());
                paramArrayList1.add(paramView2);
                FragmentTransitionCompat21.addTargets(localTransition1, paramArrayList1);
              }
            }
          }
          FragmentTransitionCompat21.excludeViews(paramObject3, localTransition1, paramArrayList1, true);
          return true;
        }
      });
      setSharedElementEpicenter(localTransition1, paramEpicenterView);
    }
  }
  
  public static void beginDelayedTransition(ViewGroup paramViewGroup, Object paramObject)
  {
    TransitionManager.beginDelayedTransition(paramViewGroup, (Transition)paramObject);
  }
  
  private static void bfsAddViewChildren(List<View> paramList, View paramView)
  {
    int k = paramList.size();
    if (containedBeforeIndex(paramList, paramView, k)) {}
    for (;;)
    {
      return;
      paramList.add(paramView);
      int i = k;
      while (i < paramList.size())
      {
        paramView = (View)paramList.get(i);
        if ((paramView instanceof ViewGroup))
        {
          paramView = (ViewGroup)paramView;
          int m = paramView.getChildCount();
          int j = 0;
          while (j < m)
          {
            View localView = paramView.getChildAt(j);
            if (!containedBeforeIndex(paramList, localView, k)) {
              paramList.add(localView);
            }
            j += 1;
          }
        }
        i += 1;
      }
    }
  }
  
  public static Object captureExitingViews(Object paramObject, View paramView1, ArrayList<View> paramArrayList, Map<String, View> paramMap, View paramView2)
  {
    Object localObject = paramObject;
    if (paramObject != null)
    {
      captureTransitioningViews(paramArrayList, paramView1);
      if (paramMap != null) {
        paramArrayList.removeAll(paramMap.values());
      }
      if (paramArrayList.isEmpty()) {
        localObject = null;
      }
    }
    else
    {
      return localObject;
    }
    paramArrayList.add(paramView2);
    addTargets((Transition)paramObject, paramArrayList);
    return paramObject;
  }
  
  private static void captureTransitioningViews(ArrayList<View> paramArrayList, View paramView)
  {
    if (paramView.getVisibility() == 0)
    {
      if (!(paramView instanceof ViewGroup)) {
        break label61;
      }
      paramView = (ViewGroup)paramView;
      if (!paramView.isTransitionGroup()) {
        break label33;
      }
      paramArrayList.add(paramView);
    }
    for (;;)
    {
      return;
      label33:
      int j = paramView.getChildCount();
      int i = 0;
      while (i < j)
      {
        captureTransitioningViews(paramArrayList, paramView.getChildAt(i));
        i += 1;
      }
    }
    label61:
    paramArrayList.add(paramView);
  }
  
  public static void cleanupTransitions(View paramView1, final View paramView2, final Object paramObject1, final ArrayList<View> paramArrayList1, final Object paramObject2, final ArrayList<View> paramArrayList2, final Object paramObject3, final ArrayList<View> paramArrayList3, final Object paramObject4, final ArrayList<View> paramArrayList4, final Map<String, View> paramMap)
  {
    paramObject1 = (Transition)paramObject1;
    paramObject2 = (Transition)paramObject2;
    paramObject3 = (Transition)paramObject3;
    paramObject4 = (Transition)paramObject4;
    if (paramObject4 != null) {
      paramView1.getViewTreeObserver().addOnPreDrawListener(new ViewTreeObserver.OnPreDrawListener()
      {
        public boolean onPreDraw()
        {
          this.val$sceneRoot.getViewTreeObserver().removeOnPreDrawListener(this);
          if (paramObject1 != null)
          {
            FragmentTransitionCompat21.removeTargets(paramObject1, paramArrayList1);
            FragmentTransitionCompat21.excludeViews(paramObject1, paramObject2, paramArrayList2, false);
            FragmentTransitionCompat21.excludeViews(paramObject1, paramObject3, paramArrayList3, false);
          }
          if (paramObject2 != null)
          {
            FragmentTransitionCompat21.removeTargets(paramObject2, paramArrayList2);
            FragmentTransitionCompat21.excludeViews(paramObject2, paramObject1, paramArrayList1, false);
            FragmentTransitionCompat21.excludeViews(paramObject2, paramObject3, paramArrayList3, false);
          }
          if (paramObject3 != null) {
            FragmentTransitionCompat21.removeTargets(paramObject3, paramArrayList3);
          }
          Iterator localIterator = paramMap.entrySet().iterator();
          while (localIterator.hasNext())
          {
            Map.Entry localEntry = (Map.Entry)localIterator.next();
            ((View)localEntry.getValue()).setTransitionName((String)localEntry.getKey());
          }
          int j = paramArrayList4.size();
          int i = 0;
          while (i < j)
          {
            paramObject4.excludeTarget((View)paramArrayList4.get(i), false);
            i += 1;
          }
          paramObject4.excludeTarget(paramView2, false);
          return true;
        }
      });
    }
  }
  
  public static Object cloneTransition(Object paramObject)
  {
    Object localObject = paramObject;
    if (paramObject != null) {
      localObject = ((Transition)paramObject).clone();
    }
    return localObject;
  }
  
  private static boolean containedBeforeIndex(List<View> paramList, View paramView, int paramInt)
  {
    int i = 0;
    while (i < paramInt)
    {
      if (paramList.get(i) == paramView) {
        return true;
      }
      i += 1;
    }
    return false;
  }
  
  public static void excludeSharedElementViews(Object paramObject1, Object paramObject2, Object paramObject3, ArrayList<View> paramArrayList, boolean paramBoolean)
  {
    paramObject1 = (Transition)paramObject1;
    paramObject2 = (Transition)paramObject2;
    paramObject3 = (Transition)paramObject3;
    excludeViews((Transition)paramObject1, (Transition)paramObject3, paramArrayList, paramBoolean);
    excludeViews((Transition)paramObject2, (Transition)paramObject3, paramArrayList, paramBoolean);
  }
  
  public static void excludeTarget(Object paramObject, View paramView, boolean paramBoolean)
  {
    ((Transition)paramObject).excludeTarget(paramView, paramBoolean);
  }
  
  private static void excludeViews(Transition paramTransition1, Transition paramTransition2, ArrayList<View> paramArrayList, boolean paramBoolean)
  {
    if (paramTransition1 != null)
    {
      if (paramTransition2 == null) {}
      for (int i = 0;; i = paramArrayList.size())
      {
        int j = 0;
        while (j < i)
        {
          paramTransition1.excludeTarget((View)paramArrayList.get(j), paramBoolean);
          j += 1;
        }
      }
    }
  }
  
  public static void findNamedViews(Map<String, View> paramMap, View paramView)
  {
    if (paramView.getVisibility() == 0)
    {
      String str = paramView.getTransitionName();
      if (str != null) {
        paramMap.put(str, paramView);
      }
      if ((paramView instanceof ViewGroup))
      {
        paramView = (ViewGroup)paramView;
        int j = paramView.getChildCount();
        int i = 0;
        while (i < j)
        {
          findNamedViews(paramMap, paramView.getChildAt(i));
          i += 1;
        }
      }
    }
  }
  
  private static Rect getBoundsOnScreen(View paramView)
  {
    Rect localRect = new Rect();
    int[] arrayOfInt = new int[2];
    paramView.getLocationOnScreen(arrayOfInt);
    localRect.set(arrayOfInt[0], arrayOfInt[1], arrayOfInt[0] + paramView.getWidth(), arrayOfInt[1] + paramView.getHeight());
    return localRect;
  }
  
  public static String getTransitionName(View paramView)
  {
    return paramView.getTransitionName();
  }
  
  private static boolean hasSimpleTarget(Transition paramTransition)
  {
    return (!isNullOrEmpty(paramTransition.getTargetIds())) || (!isNullOrEmpty(paramTransition.getTargetNames())) || (!isNullOrEmpty(paramTransition.getTargetTypes()));
  }
  
  private static boolean isNullOrEmpty(List paramList)
  {
    return (paramList == null) || (paramList.isEmpty());
  }
  
  public static Object mergeTransitions(Object paramObject1, Object paramObject2, Object paramObject3, boolean paramBoolean)
  {
    boolean bool2 = true;
    Transition localTransition = (Transition)paramObject1;
    paramObject1 = (Transition)paramObject2;
    paramObject3 = (Transition)paramObject3;
    boolean bool1 = bool2;
    if (localTransition != null)
    {
      bool1 = bool2;
      if (paramObject1 != null) {
        bool1 = paramBoolean;
      }
    }
    if (bool1)
    {
      paramObject2 = new TransitionSet();
      if (localTransition != null) {
        ((TransitionSet)paramObject2).addTransition(localTransition);
      }
      if (paramObject1 != null) {
        ((TransitionSet)paramObject2).addTransition((Transition)paramObject1);
      }
      if (paramObject3 != null) {
        ((TransitionSet)paramObject2).addTransition((Transition)paramObject3);
      }
      return paramObject2;
    }
    paramObject2 = null;
    if ((paramObject1 != null) && (localTransition != null)) {
      paramObject1 = new TransitionSet().addTransition((Transition)paramObject1).addTransition(localTransition).setOrdering(1);
    }
    while (paramObject3 != null)
    {
      paramObject2 = new TransitionSet();
      if (paramObject1 != null) {
        ((TransitionSet)paramObject2).addTransition((Transition)paramObject1);
      }
      ((TransitionSet)paramObject2).addTransition((Transition)paramObject3);
      return paramObject2;
      if (paramObject1 == null)
      {
        paramObject1 = paramObject2;
        if (localTransition != null) {
          paramObject1 = localTransition;
        }
      }
    }
    return paramObject1;
  }
  
  public static void removeTargets(Object paramObject, ArrayList<View> paramArrayList)
  {
    paramObject = (Transition)paramObject;
    int i;
    if ((paramObject instanceof TransitionSet))
    {
      paramObject = (TransitionSet)paramObject;
      int j = ((TransitionSet)paramObject).getTransitionCount();
      i = 0;
      while (i < j)
      {
        removeTargets(((TransitionSet)paramObject).getTransitionAt(i), paramArrayList);
        i += 1;
      }
    }
    if (!hasSimpleTarget((Transition)paramObject))
    {
      List localList = ((Transition)paramObject).getTargets();
      if ((localList != null) && (localList.size() == paramArrayList.size()) && (localList.containsAll(paramArrayList)))
      {
        i = paramArrayList.size() - 1;
        while (i >= 0)
        {
          ((Transition)paramObject).removeTarget((View)paramArrayList.get(i));
          i -= 1;
        }
      }
    }
  }
  
  public static void setEpicenter(Object paramObject, View paramView)
  {
    ((Transition)paramObject).setEpicenterCallback(new Transition.EpicenterCallback()
    {
      public Rect onGetEpicenter(Transition paramAnonymousTransition)
      {
        return this.val$epicenter;
      }
    });
  }
  
  private static void setSharedElementEpicenter(Transition paramTransition, EpicenterView paramEpicenterView)
  {
    if (paramTransition != null) {
      paramTransition.setEpicenterCallback(new Transition.EpicenterCallback()
      {
        private Rect mEpicenter;
        
        public Rect onGetEpicenter(Transition paramAnonymousTransition)
        {
          if ((this.mEpicenter == null) && (this.val$epicenterView.epicenter != null)) {
            this.mEpicenter = FragmentTransitionCompat21.getBoundsOnScreen(this.val$epicenterView.epicenter);
          }
          return this.mEpicenter;
        }
      });
    }
  }
  
  public static void setSharedElementTargets(Object paramObject, View paramView, Map<String, View> paramMap, ArrayList<View> paramArrayList)
  {
    paramObject = (TransitionSet)paramObject;
    paramArrayList.clear();
    paramArrayList.addAll(paramMap.values());
    paramMap = ((TransitionSet)paramObject).getTargets();
    paramMap.clear();
    int j = paramArrayList.size();
    int i = 0;
    while (i < j)
    {
      bfsAddViewChildren(paramMap, (View)paramArrayList.get(i));
      i += 1;
    }
    paramArrayList.add(paramView);
    addTargets(paramObject, paramArrayList);
  }
  
  public static Object wrapSharedElementTransition(Object paramObject)
  {
    if (paramObject == null) {}
    do
    {
      return null;
      paramObject = (Transition)paramObject;
    } while (paramObject == null);
    TransitionSet localTransitionSet = new TransitionSet();
    localTransitionSet.addTransition((Transition)paramObject);
    return localTransitionSet;
  }
  
  public static class EpicenterView
  {
    public View epicenter;
  }
  
  public static abstract interface ViewRetriever
  {
    public abstract View getView();
  }
}


/* Location:              /Users/tom/Downloads/dex2jar-2.0/classes.jar!/android/support/v4/app/FragmentTransitionCompat21.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       0.7.1
 */