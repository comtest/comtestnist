module Data.Graph.Inductive.Query.BCC (bcc) where
{ import Data.Graph.Inductive.Graph;
  import Data.Graph.Inductive.Query.DFS;
  import Data.Graph.Inductive.Query.ArtPoint;
   
  gComponents :: (DynGraph gr) => gr a b -> [gr a b];
  gComponents g = map (\ (x, y) -> mkGraph x y) (zip ln le)
    where { ln = map (\ x -> [(u, l) | (u, l) <- vs, elem u x]) cc;
            le = map (\ x -> [(u, v, l) | (u, v, l) <- es, elem u x]) cc;
            (vs, es, cc) = (labNodes g, labEdges g, components g)};
   
  embedContexts ::
                (DynGraph gr) => Context a b -> [gr a b] -> [gr a b];
  embedContexts (_, v, l, s) gs = map (\ (x, y) -> x & y) (zip lc gs)
    where { lc = map (\ e -> (e, v, l, e)) lc';
            lc' = map (\ g -> [e | e <- s, gelem (snd e) g]) gs};
   
  findGraph :: (DynGraph gr) => Node -> [gr a b] -> Decomp gr a b;
  findGraph _ [] = error "findGraph: empty graph list";
  findGraph v (g : gs)
    = case match v g of
          { (Nothing, _) -> findGraph v gs;
            (Just c, g') -> (Just c, g')};
   
  splitGraphs :: (DynGraph gr) => [gr a b] -> [Node] -> [gr a b];
  splitGraphs gs [] = gs;
  splitGraphs [] _ = error "splitGraphs: empty graph list";
  splitGraphs (g : gs) (v : vs) = splitGraphs (gs'' ++ gs) vs
    where { gs'' = embedContexts c gs';
            gs' = gComponents g';
            (Just c, g') = findGraph v (g : gs)};
   
  bcc :: (DynGraph gr) => gr a b -> [gr a b];
  bcc g = splitGraphs [g] (ap g)}
